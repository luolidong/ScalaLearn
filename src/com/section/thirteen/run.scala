package com.section.thirteen

/**
  * 包与引用
  * 1 任何你能写出来的顶层包都被当做_root_包的成员
  * 2 scala的import子句比Java更加灵活： 可以出现在任何地方。可以指的是（单例或正统的）对象及包。可以重命名或隐藏一些被引用的成员
  */

package launch {
  class Booster3
}

package bobsrockets {
  package navigation {
    package launch {
      class Booster1
    }

    class MissionControl {
      val booster1 = new launch.Booster1
      val booster2 = new bobsrockets.launch.Booster2
      val booster3 = new _root_.com.section.thirteen.launch.Booster3
    }
  }

  package launch {
    class Booster2
  }
}

/**
  * 只引用Fruits的Apple和Orange
  * Apple重命名McIntosh
  * 引用Fruits的所有成员，Pear除外
  * */
import bobsdelights.Fruits.{Apple,Orange}
import bobsdelights.Fruits.{Apple=>McIntosh,Orange}
import bobsdelights.Fruits.{Pear=>_,_}


/**
  * 访问修饰符
  * 私有成员
  * f 在Inner中被声明为private而访问不在Inner之内。 Java 允许这两种访问。因为它允许外部类访问其内部类的私有成员
  * private被标记了Outer 则说明可以包含在Out内的类和对象访问
  * private[this] 不能被同一个类的其他对象访问
  * */

class Outer {
  private[this] val speed = 10
  private val speed2 = 10

  class Inner {
    private def f() {println("*f*")}
    private[Outer] def e() {println("*f*")}

    class InnerMost {
      f()     //ok
      e()

    }
  }
//   (new Inner).f()     //不可访问
  (new Inner).e() //可访问

  def show(outer:Outer): Unit = {
//    outer.speed      //
  }

  def show2(outer:Outer): Unit = {
    outer.speed2
  }
}


/**
  * 访问修饰符
  * 保护成员
  * protected 定义了成员的类的子类可以访问，而Java还允许同一个包的其他类中进行这种访问
  * protected 则说明可以包含在Out内的类和对象访问
  * */
class Super {
  protected def f(){println("*f*")}
  protected[thirteen] def e(){println("*f*")}
}

class Sub extends Super {
  f()
  e()
}

class Other {
//   (new Super).f()   //不可访问
  (new Super).e()   //可访问
}

object run extends App {
  val outer = new Outer
}
