package com.smile.stream

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

object CountWord {

  def main(args: Array[String]): Unit = {
    val path = "D:/flink/data/hello.txt"

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    val data = env.readTextFile(path)

    import org.apache.flink.streaming.api.scala._

    data.flatMap(_.toLowerCase.split("\t"))
      .filter(_.nonEmpty)
      .map((_, 1))
      .keyBy(e => e._2)
      .sum(1).print()
  }

}
