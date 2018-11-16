package com.section.eight

import scala.io.Source

/**
  * 函数和闭包
  * 1 私有方法processLine转换成局部processLine。processLine在processFile外部无法访问。
  * 2 本地函数processLine可以访问包含其函数的参数
  * 3 闭包捕获的是变量本身，不是变量的值。闭包没改变了变量的值，在闭包外可见
  * 4 重复参数（可变长度参数列表），可在参数类型之后加一个星号
  * 5 尾递归
  */
object run extends App {
  def processFile(filename: String, width: Int) {
     def processLine(line: String): Unit = {
      if (line.length > width)
        println(filename + ":" + line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(line)
  }

//  private def processFile(filename: String, width: Int, line: String): Unit = {
//    if (line.length > width)
//      println(filename + ":" + line.trim)
//  }

  def addmore(x:Int) = {
    more += 1
    more + x
  }

  var more = 10

  println(addmore(1))
  println(more)

  def echo(args:String*): Unit = {
    for (arg<-args)
      println(arg)
  }

  echo("hello", "world")
}
