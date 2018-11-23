package com.section.sixteen

/**
  * 插入排序
  */
object insertSort extends App{
    def isort(xs:List[Int]) : List[Int] = xs match {
      case List() => List()
      case x::xs1 => insert(x,isort(xs1))
    }

  def insert(x:Int,xs:List[Int]):List[Int] = xs match {
    case List() => List(x)
    case y::ys => if (x <= y) x :: xs
                   else y :: insert(x, ys)
  }

  val arr = List(6,5,4,3,2,1)
  println(isort(arr))
}
