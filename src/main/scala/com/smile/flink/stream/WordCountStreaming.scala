package com.smile.flink.stream

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.api.windowing.time.Time

/**
 * windows nc -l -p 9999
 */
object WordCountStreaming {

  def main(args: Array[String]): Unit = {

    val senv = StreamExecutionEnvironment.getExecutionEnvironment
    val text = senv.socketTextStream("localhost", 9999)

    import org.apache.flink.streaming.api.scala._

    text.flatMap(_.split(","))
      .filter(_.nonEmpty)
      .map((_, 1))
      .keyBy(e => e._1)
      .timeWindow(Time.seconds(3))
      .sum(1)
      .print()
    senv.execute("Streaming WordCount")
  }


}
