package com.section.eleven

/**
  * Scala的层级
  * 1 根类Any有2个子类：AnyVal 和 AnyRef
  * 2 AnyVal的子类：Byte Short Char Int Long Float Double Boolean 和 Unit
  * 3 AnyRef:所有引用类的基类
  * 4 底层类型：scala.Null 和 scala.Nothing
  * 5 Nothing是Scala类层级的最低端，他是任何其他类型的子类型。Nothing的一个用处是标明不正常的终止
  */
object run extends App {

  def devide(x:Int, y:Int) : Int =
    if (y != 0) x / y
    else error("can't divide by zero")

  println(devide(1,2))
  println(devide(1,0))
}
