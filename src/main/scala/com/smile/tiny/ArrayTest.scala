package com.smile.tiny

object ArrayTest {


  def main(args: Array[String]): Unit = {
    val words = Array("hello tom hello jim hello jerry", "hello Hatano")
    val tmp = words.map(x => x.split(" "))
    println(tmp(0).toBuffer, tmp(1).toBuffer)

    /**
     * 扁平化操作，数组内的数组合并
     */
    println(tmp.flatten.toBuffer)
  }
}
