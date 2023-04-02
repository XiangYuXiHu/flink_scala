package com.smile.flink.stream

import java.{lang, util}

import org.apache.flink.streaming.api.collector.selector.OutputSelector
import org.apache.flink.streaming.api.functions.source.SourceFunction
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.api.scala._

object SplitAndSelectStream {

  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    var counter = 0

    env.addSource(new SourceFunction[Long] {
      override def run(ctx: SourceFunction.SourceContext[Long]): Unit = {
        while (counter < 100) {
          ctx.collect(counter)
          counter += 1
          Thread.sleep(1000)
        }
      }

      override def cancel(): Unit = {
        false
      }
    }).split(new OutputSelector[Long] {
      override def select(value: Long): lang.Iterable[String] = {
        val list = new util.ArrayList[String]()
        if (value % 2 == 0) {
          list.add("even")
        } else {
          list.add("odd")
        }
        list
      }
    }).select("even").print()
    env.execute()
  }
}
