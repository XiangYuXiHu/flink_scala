package com.smile.tiny

class cat(val name: String) {
  def catchMouse(): Unit = {
    println(name + " catch mouse")
  }
}

class dog(val name: String)

object ImplicitTest {

  implicit val message = "good"
  implicit val age = 100

  /**
   * 如果方法有多个隐式参数，只需一个implicit 修饰即可
   *
   * @param content
   * @param age
   */
  def say(implicit content: String, age: Int): Unit = {
    println(content + "  " + age)
  }

  implicit def obj2Cat(obj: Object): cat = {
    if (obj.getClass == classOf[dog]) {
      val dog = obj.asInstanceOf[dog]
      new cat(dog.name)
    }
    else Nil
  }

  def main(args: Array[String]): Unit = {
    // 这里调用方法say没有传参，但由于这里定义了了隐式参数 content
    // 且类型也为String，解释器就会找到已经定义好的隐式参数msg
    say

    val dog = new dog("dd")
    dog.catchMouse
  }
}
