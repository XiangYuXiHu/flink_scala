package com.smile.tiny


import scala.collection.JavaConverters
import scala.collection.mutable.ArrayBuffer

object Java2Scala {

  def main(args: Array[String]): Unit = {
    val element = ArrayBuffer("hello", "world", "china")

    /**
     * scala to java
     */
    val javaList = JavaConverters.bufferAsJavaListConverter(element).asJava

    println(javaList)
    val scalaList = JavaConverters.asScalaBufferConverter(javaList).asScala
    for (elem <- scalaList) {
      println(elem)
    }
  }

}
