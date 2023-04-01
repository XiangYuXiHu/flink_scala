package com.smile.flink.stream

import java.io.{BufferedReader, FileReader}

import org.apache.flink.api.scala._
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

import scala.collection.mutable

object CollectionStream {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    //    collectionStream(env)

    csvStream(env)
  }

  def collectionStream(env: StreamExecutionEnvironment): Unit = {
    val data = 1 to 10
    env.fromCollection(data)
      .map(x => x + 1)
      .print()
    env.execute("collection stream")
  }

  def csvStream(env: StreamExecutionEnvironment): Unit = {
    val path = "D:/data/person.csv"
    val reader: BufferedReader = new BufferedReader(new FileReader(path))
     reader.readLine()
    val persons = new mutable.HashSet[Person]()

    var line: String = null
//    while ({line = reader.readLine(); line!=null}) {
    while ({line = reader.readLine(); Option(line).isDefined}) {
      val item: Array[String] = line.split(",")
      val name = item(0)
      val age = item(1).toInt
      val job = item(2)

      val p = new Person(name, age, job)
      persons.add(p)
    }
    println(persons)
  }

  case class Person(name: String, age: Int, job: String)

}
