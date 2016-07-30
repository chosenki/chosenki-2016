package com.ki.scala

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by Administrator on 2016/7/27.
  */
object Main {

  class Demo {
    def runDemo(name:String) = {
      println("Hello "+name)
    }
  }

  def f(x:Int):Future[Unit] = Future{
    println(x*x)
    Console.flush
//    blocking{
//      Thread.sleep((x seconds).toMillis)
//    }
  }


  def main(args:Array[String]):Unit = {
//    println("Hello Scala")
//    new Demo runDemo "WangPan"
//    new Demo().runDemo("WP")
    println("Hello Scala A")

    val fSerial = f(1).flatMap(res1 => f(2)).flatMap(res2 => f(3)).flatMap(res3 => f(4))
    fSerial.onComplete {
      case res => println("Success:"+res.isSuccess)
    }

    println("Hello Scala B")
  }

}
