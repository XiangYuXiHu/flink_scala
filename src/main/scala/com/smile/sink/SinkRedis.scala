package com.smile.sink

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.redis.RedisSink
import org.apache.flink.streaming.connectors.redis.common.config.FlinkJedisPoolConfig
import org.apache.flink.streaming.connectors.redis.common.mapper.{RedisCommand, RedisCommandDescription, RedisMapper}

object SinkRedis {

  private val REDIS_KEY = "person_message"

  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val personStreaming: DataStream[Person] = env.fromElements(Person("jim", 19, "male"),
      Person("lucy", 20, "womale"), Person("lily", 21, "womale"))

    val redisConf: FlinkJedisPoolConfig = new FlinkJedisPoolConfig.Builder()
      .setHost("localhost")
      .setPort(6379).setTimeout(30000).build()

    personStreaming.addSink(new RedisSink[Person](redisConf, new MyRedisMapper))

    env.execute("sink redis")
  }

  case class Person(name: String, age: Int, gender: String)

  class MyRedisMapper extends RedisMapper[Person] {
    override def getCommandDescription: RedisCommandDescription = {
      new RedisCommandDescription(RedisCommand.HSET, REDIS_KEY)
    }

    override def getKeyFromData(t: Person): String = {
      t.name
    }

    override def getValueFromData(t: Person): String = {
      t.age + ":" + t.gender
    }
  }

}
