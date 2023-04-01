package com.smile.tiny

import scala.collection.{JavaConverters, mutable}
import scala.collection.mutable.ArrayBuffer
import java.util

object Java2Scala {

  def main(args: Array[String]): Unit = {
    val element = ArrayBuffer("hello", "world", "china")

    /**
     * scala to java
     */
    val list: util.List[String] = JavaConverters.bufferAsJavaListConverter(element).asJava
    println(list)
    val scalaBuffer: mutable.Buffer[String] = JavaConverters.asScalaBufferConverter(list).asScala
    for (elem <- scalaBuffer) {
      println(elem)
    }
  }

}
