package com.smile.tiny

object ForTest {

  def main(args: Array[String]): Unit = {
    val arr = Array(0, 1, 2, 3, 4, 5, 6)

    val other = for (e <- arr if e % 2 == 0) yield 10 * e
    for (e <- other) {
      println(e)
    }
  }
}
