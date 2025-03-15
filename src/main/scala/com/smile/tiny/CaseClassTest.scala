package com.smile.tiny


object CaseClassTest {

  class PersonA

  case class Teacher(name: String, sub: String) extends PersonA

  case class Student(name: String, cla: String) extends PersonA

  def check(p: PersonA): Unit = {
    p match {
      case Student(name, cla) => println("Student name " + name + " class " + cla)
      case Teacher(name, sub) => println("Teacher name " + name + " sub" + sub)
      case _ => println("none")
    }
  }

  val ages = Map("jack" -> 18, "tom" -> 19, "lucy" -> 20)

  def getAge(name: String): Unit = {
    val age = ages.get(name)
    age match {
      case Some(age) => println(name + " age is " + age)
      case None => println("none")
    }
  }

  def main(args: Array[String]): Unit = {
    check(Teacher("jack", "chinese"))
    getAge("jack")

  }

}
