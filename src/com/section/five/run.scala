package com.section.five

/** 基本类型和操作
  * 标识符中能作为前缀操作符用的只有+,-,!和~。对类型定义命名为unary_!的方法。除了这4种标识符，其他的都不行
  * 后缀操作符是不用点或者括号调用的不带任何参数的方法
  * 中缀操作符：数学运算符（+，-，*，/），关系和逻辑运算符（>,<,<=,>=, &&,||）,位操作符（&，|，^）
  */
object run extends App{
  //前缀
  println(- 2.0)
  println((2.0).unary_-)

  //后缀
  val s = "hello,world!"
  s.toLowerCase

  s toLowerCase

  //中缀
  1 + 1

  println("aa" == "aa")
}
