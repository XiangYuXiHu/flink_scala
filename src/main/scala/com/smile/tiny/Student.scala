package com.smile.tiny

/*
*    在 Scala 中，类并不用声明为 public。
*    如果没有定义构造器, 类会有一个默认的空参构造器
*    var 修饰的变量, 这个变量对外提供 getter setter 方法
*    val 修饰的变量, 对外提供 getter 方法,没有 setter
**/
class Student {
  // _ 表示一个占位符, 编译器会根据你变量的具体类型赋予相应初始值
  // 注意: 使用_ 占位符是, 变量类型必须指定
  var name: String = _
  var age: Int = _
  //val 修饰的变量不能使用占位符
  val school: String = "北大"

  // private[this]关键字标识该属性只能在类的内部访问, 伴生类不能访
  private[this] val province: String = "北京"
}
