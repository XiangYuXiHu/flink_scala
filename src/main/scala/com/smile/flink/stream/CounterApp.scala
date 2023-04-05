package com.smile.flink.stream

import org.apache.flink.api.common.accumulators.LongCounter
import org.apache.flink.api.common.functions.{RichMapFunction, RuntimeContext}
import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.configuration.Configuration
import org.apache.flink.core.fs.FileSystem.WriteMode
import org.apache.flink.streaming.api.scala._

object CounterApp {

  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val data = env.fromElements("hadoop", "spark", "java", "flink")

    data.map(new RichMapFunction[String, String] {

      val counter = new LongCounter()

      override def open(parameters: Configuration): Unit = {
        println("----------open-------")
        getRuntimeContext.addAccumulator("counter", counter)
      }

      override def map(value: String): String = {
        counter.add(1)
        value
      }

    }).setParallelism(2).writeAsText("d://a.text", WriteMode.OVERWRITE)

    val result = env.execute("counterApp")
    val num = result.getAccumulatorResult[Long]("counter")
    println(num)
  }

}
