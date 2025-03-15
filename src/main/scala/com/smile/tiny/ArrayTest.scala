package com.smile.tiny

object ArrayTest {


  def main(args: Array[String]): Unit = {
    val nums = new Array[Int](10)
    for (i <- nums.indices) {
      print(nums(i) + " ")
    }

    val strs = Array("hello you", "scala me")
    println(strs.toBuffer + " " + strs(0))

    val words = Array("hello tom hello jim hello jerry", "hello Hatano")
    val tmp = words.map(x => x.split(" "))
    println(tmp(0).toBuffer, tmp(1).toBuffer)

    println("flatMap: " + words.flatMap(word => word.split(" ")).toBuffer)
    println("flatMap1: " + words.flatMap(_.split(" ")).toBuffer)
    println("word count:" + words.flatMap(_.split(" ")).map((_, 1)).map(_._2).reduceLeft(_ + _))

    /**
     * 扁平化操作，数组内的数组合并
     */
    println(tmp.flatten.toBuffer)

    for (i <- 1 to 3; j <- 1 to 3) {
      print(f"${10 * i + j}%3d")
    }

    val num_list = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val list1 = num_list.filter(_ % 2 == 0).map(_ * 10)
    println(list1.toBuffer)
    println(num_list.reduce((t1, t2) => t1 + t2))
  }
}
