package com.section.four

/** 类和对象
  * 特质
  * 1 使用方法： 在对象名之后加上 extends App
  * 2 花括号之间的代码被收集进了单例对象的主构造器，并在类初始化时执行
  * 3 缺点：不能访问命令行参数；因为JVM线程模型的局限，多线程程序需要自行编写main方法
  * 4 适用场景：程序相对简单冰鞋是单线程。
  */
object run extends  App{
    println(ChecksumAccmulator.calculate("aa"))
    println(ChecksumAccmulator.calculate("aa"))
}
