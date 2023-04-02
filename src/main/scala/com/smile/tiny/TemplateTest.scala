package com.smile.tiny

import com.smile.tiny.clothesEnum.clothesEnum

object clothesEnum extends Enumeration {
  type clothesEnum = Value
  val 上衣, 内衣, 裤子, 袜子 = Value
}

abstract class Message[T](s: T) {
  def get: T = s
}

class StrMessage[String](msg: String) extends Message(msg)

class IntMessage[Int](msg: Int) extends Message(msg)

class Clothes[A, B, C](val clothesType: A, var color: B, var siz: C)

object TemplateTest {

  def getData[T](l: List[T]) = {
    l(l.length / 2)
  }

  def main(args: Array[String]): Unit = {
    val msg = new StrMessage[String]("hai")
    val value = new IntMessage[Int](100)
    println(msg.get + " " + value.get)

    val cl = new Clothes[clothesEnum, String, String](clothesEnum.上衣, "红色", "32L")
    println(cl.siz)

    val list = List(1, 2, 3, 4, 5, 6)
    println(getData(list))
  }
}
