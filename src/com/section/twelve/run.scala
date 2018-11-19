package com.section.twelve

import scala.collection.mutable.ArrayBuffer

/**
  * 特质
  * 1 特质是scala代码复用的基础单元
  * 2 类只能继承唯一的超类，类可以混入任意多个特质
  * 3 特质就想是带有具体方法的Java接口。
  * 4 特质可以声明字段和维持状态值
  * 5 特质不能有类参数
  * 6 super调用在类里面是静态绑定，在特质里是动态绑定
  * 7 Ordered特质定义了 > < >= <=,没有equals
  * 8 特质的堆叠
  *
  */
object run extends App {
  class Rational(n: Int, d: Int) extends Ordered[Rational]{
    require(d != 0)
    private val g = gcd(n.abs,d.abs)

    val numer: Int = n / g
    val denom: Int = d / g

    //辅助构造器
    def this() = this(1, 1)
    def this(i:Int) = this(i, 1)

    override def toString = numer + "/" + denom

    override def compare(that: Rational): Int = {
      (this.numer * that.denom) - (that.numer * this.denom)
    }
  }

    def gcd(a: Int, b: Int): Int =
      if (b == 0) a else gcd(b, a % b)

  trait Philosophical {
    def Philosophize(): Unit = {
      println("this is Philosophical")
    }
  }

  trait HasLegs {
    def Philosophize(): Unit = {
      println("this is HasLegs")
    }
  }

  //error
//  trait HasLegs2(x:Int) {
//    def Philosophize(): Unit = {
//      println("this is HasLegs")
//    }
//  }

  class Frog extends HasLegs with Philosophical{
    override def Philosophize() = super.Philosophize()
  }

  val frog = new Frog
  frog.Philosophize()


  //
  abstract class IntQueue {
    def get():Int
    def put(x:Int)
  }

  class BasicIntQueue extends IntQueue {
    private val buf = new ArrayBuffer[Int]
    def get(): Int = buf.remove(0)
    def put(x: Int): Unit = {buf += x}
  }

  /**
    * extends IntQueue 说明了此特质只能混入扩展了IntQueue的类中
    * 越靠近右侧的特质越先起作用。如果那个方法调用了super，它调用其左侧特质的方法。
    */
  trait Doubling extends IntQueue {
    abstract override def put(x:Int) {super.put(2 * x)}
  }

  trait Incrementing extends IntQueue {
    abstract override def put(x: Int): Unit = {super.put(x + 1)}
  }

  trait  Filter extends IntQueue {
    abstract override def put(x: Int): Unit = {if (x >= 0) super.put(x)}
  }

  val queue = (new BasicIntQueue with Incrementing with Filter)
  queue.put(-1);queue.put(0);queue.put(1)
  println(queue.get())
  println(queue.get())

  val queue2 = (new BasicIntQueue with Filter with Incrementing)
  queue2.put(-1);queue2.put(0);queue2.put(1)
  println(queue2.get())
  println(queue2.get())
  println(queue2.get())
}
