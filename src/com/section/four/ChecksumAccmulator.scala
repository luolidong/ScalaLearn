package com.section.four

/**
  * 1 public 是 scala默认的访问级别
  * 2 scala 不能定义静态成员，而代之以定义[单例对象].除了用object关键字代替class关键字以外，单例对象的定义与类定义一致。
  * 3 单例对象和某个类共享同一个名称时，它就被称为是这个类的伴生对象
  * 4 类和它的伴生对象必须定义在一个源文件内
  * 5 类被称为单例对象的半生类。
  * 6 类和它的伴生对象可以互相访问其私有成员
  * 7 类和单例对象的区别：单例对象不带参数，类可以。单例对象在第一次被访问的时候才会被初始化
  */

import scala.collection.mutable.Map

class ChecksumAccmulator {
  private var sum = 0

  //  def add(b: Byte) : Unit = sum += b                /*返回值是 BoxedUnit */
  def add(b: Byte) {
    sum += b
  } /*返回值是 BoxedUnit */
  //  def add(b: Byte) : Unit = {sum += b.toInt}        /*返回值是 BoxedUnit */
  //  def add(b: Byte) = {sum += b.toInt;sum}           /*返回值是 Int */
  //  def add(b: Byte) : Int = {sum += b.toInt;sum}     /*返回值是 Int */
  //  def add(b: Byte) {sum += b.toInt;sum}             /*返回值是 BoxedUnit */


  def checksum(): Int = ~(sum & 0xff) + 1
}

object ChecksumAccmulator {
  private val cache = Map[String, Int]()

  def calculate(s : String) : Int = {
    if (cache.contains(s)) {
      cache(s)
    } else {
      val acc = new ChecksumAccmulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs

    }
  }

}
