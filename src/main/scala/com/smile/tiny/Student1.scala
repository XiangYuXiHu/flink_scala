package com.smile.tiny

/*
*    Student1(val name: String, var age: Int)
*    定义个 2 个参数的主构造器
**/
class Student1(val name: String, var age: Int) {
  var gender: String = _

  // 辅助构造器, 使用 def this
  // 在辅助构造器中必须先调用类的主构造器
  def this(name: String, age: Int, gender: String) {
    this(name, age)
    this.gender = gender
  }

  // private[this]关键字标识该属性只能在类的内部访问, 伴生类不能访
  private[this] val province: String = "北京"

  def sayHello(name: String = "defaultName", age: Int = 18): Unit = {
    println("name:" + name + ",age:" + age)
  }
}

/**
 * // 类的伴生对象
 */
object Test1 {
  def main(args: Array[String]): Unit = {
    // 调用主构造器
    val s = new Student1("laoduan", 38)
    println(s"${s.name} ${s.age}")

    s.sayHello("jim")

    // 调用的是辅助构造器
    val s1 = new Student1("laoYang", 18, "male")
    println(s"${s1.gender}")
  }
}
