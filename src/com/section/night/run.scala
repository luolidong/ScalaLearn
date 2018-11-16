package com.section.night

/**
  * 控制抽象
  * 1 减少代码重复
  * 2 简化代码
  * 3 函数的柯理化 柯里化(Currying)指的是将原来接受两个参数的函数变成新的接受一个参数的函数的过程。新的函数返回一个以原有第二个参数为参数的函数。
  * 4 scala的任何方法调用，如果只传入一个参数，就能可选的用花括号代替小括号
  * 5 传名函数,实现传名函数，要定义参数的类型开始于=>而不是()=>
  */
object run extends App {
  //柯理化
  def sum(x:Int)(y:Int) = x + y

  println(sum(1)(2))

  println(sum(1){2})

  println { "hello" }

  val assertionsEnabled = true

  //传名参数
  def boolAssert(predicate: => Boolean) =
    if (assertionsEnabled && ! predicate)
      throw new AssertionError()

  println(boolAssert(1 / 0 == 0))

}
