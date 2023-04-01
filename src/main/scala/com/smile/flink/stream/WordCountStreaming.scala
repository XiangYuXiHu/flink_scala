package com.smile.flink.stream

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.windowing.time.Time
import org.apache.flink.streaming.api.scala._

/**
 * windows nc -l -p 9999
 */
object WordCountStreaming {

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment
    wordCountFromSocket(env)
  }


  def wordCountFromSocket(env: StreamExecutionEnvironment): Unit = {
    val data = env.socketTextStream("localhost", 9999)
    data.flatMap(_.toLowerCase.split(","))
      .filter(_.nonEmpty)
      .map((_, 1))
      .keyBy(e => e._1)
      .timeWindow(Time.seconds(3))
      .sum(1)
      .print()
    env.execute("socket word count")
  }


}
