package com.smile.tiny

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

object CollectionTest {

  def main(args: Array[String]): Unit = {
    //    list_opr()
    //    listBuffer_opr()
    hashSet_opr()
  }

  /**
   * 不可变list
   */
  def list_opr(): Unit = {
    val li = List(1, 3, 4)
    /**
     * 在原list上前面添加一个元素，形成一个新的list
     */
    val li1 = 0 :: li
    println(li1)
    /**
     * list后面添加一个新的元素，形成一个新的list
     */
    val li2 = li :+ 5
    println(li2)
  }

  /**
   * 可变list
   */
  def listBuffer_opr(): Unit = {
    val li = ListBuffer[String]()

    li.append("a")
    li += "c"

    var li2 = ListBuffer("l", "m")
    // 追到到li中，并没有生成新的list
    li ++= li2
    println(li)

    // 生成了新的li
    var li3 = li ++ li2
    println(li3)
  }

  /**
   * 不可变set
   */
  def set_opr(): Unit = {
    var s1 = Set(1, 2, 4)
    var s2 = Set(4, 5, 6)

    // 集合拼接成一个新的集合
    var s3 = s1 ++ s2
    print(s3)
  }

  def hashSet_opr(): Unit = {
    var set = new mutable.HashSet[Int]()
    set.add(1)
    set += 4
    set -= 5
    // 移除,若不存在也没事
    set.remove(2)
    // 不存在就添加
    set.update(2, true)
    print(set)
  }
}
