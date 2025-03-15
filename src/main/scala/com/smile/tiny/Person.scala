package com.smile.tiny

import java.io.{FileNotFoundException, IOException}

object Person {

  def main(args: Array[String]): Unit = {
    val tom = new Person("tom")
    val jim = new Person("jim")
    tom.sayHello(jim.name)
    tom.makeFriend(jim)
    tom.level(20000)
  }

  trait Hello {
    def sayHello(name: String)
  }

  trait MakeFriend {
    def makeFriend(other: Person)
  }

  class Person(val name: String) extends Hello with MakeFriend {

    override def sayHello(name: String): Unit = {
      println("Hello: " + name)
    }

    override def makeFriend(other: Person): Unit = {
      println("My name is " + name + " make friend " + other.name)
    }

    def level(salary: Int): Unit = {
      salary match {
        case 10000 => println("salary ok!")
        case 20000 => println("salary good")
        case 30000 => println("salary very good")
        case _ => println("should think way!")
      }
    }

    def processException(e: Exception): Unit = {
      e match {
        case e1: FileNotFoundException => println("FileNotFoundException")
        case e2: IOException => println("IOException")
        case _: Exception => println("Exception")
      }
    }
  }

}
