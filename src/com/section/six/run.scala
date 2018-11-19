package com.section.six


/**
  * 函数式对象
  * 1 scala编译器把类内部任何既不是字段也不是方法定义的代码编译至主构造器中
  * 2 override 重载
  * 3 require 检查先决条件,失败抛出IllegalArgumentException阻止对象被构造
  * 4 辅助构造器调用终将结束于对主构造器的调用
  * 5 java里的构造器要么调用同类的其他构造器，要么调用超类构造器。scala中只有主构造器可以调用超类构造器
  * 6 重载
  * 7 隐式转换:要隐式转换起作用，需要定义在作用范围之内，定义在Rational类内，它及不在解释器的作用范围
  */

object run extends App {
  class Rational(n: Int, d: Int) {
    require(d != 0)
    private val g = gcd(n.abs,d.abs)

    val numer: Int = n / g
    val denom: Int = d / g

    //辅助构造器
    def this() = this(1, 1)
    def this(i:Int) = this(i, 1)

    override def toString = numer + "/" + denom

    def add(that: Rational) = {
      new Rational(
        numer * that.denom + that.numer * denom,
        denom * that.denom
      )
    }

    def +(that : Rational) = new Rational (numer * that.denom + that.numer * denom,denom * that.denom)
    def +(i: Int) = new Rational (numer + i * denom,denom)

    def *(that : Rational) = new Rational (numer * that.numer,denom * that.denom)

    def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)
  }

  implicit def IntToRational(x : Int) = new Rational(x)

  val oneHalf = new Rational(4, 2)
  val twoThirds = new Rational(2, 3)

  val default = new Rational

  val r = oneHalf add twoThirds

  println(oneHalf.toString)
  println(twoThirds.toString)
  println(default.toString)

  val r1 = oneHalf + twoThirds * oneHalf
  println(r1.toString)

  1 + oneHalf
}
