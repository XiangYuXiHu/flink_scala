package com.smile.tiny

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

  def main(args: Array[String]): Unit = {
    // 这里调用方法say没有传参，但由于这里定义了了隐式参数 content
    // 且类型也为String，解释器就会找到已经定义好的隐式参数msg
    say
  }
}
