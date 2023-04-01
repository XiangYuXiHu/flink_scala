package com.smile.flink.stream

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.scala._

object CountWord {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment
    wordCount(env)
  }

  def wordCount(env: StreamExecutionEnvironment): Unit = {
    val data = env.readTextFile("D:/flink/data/hello.txt")

    data.flatMap(_.toLowerCase().split("\t"))
      .filter(_.nonEmpty)
      .map((_, 1))
      .keyBy(e => e._1)
      .sum(1)
      .print()

    env.execute("word count")
  }


}
