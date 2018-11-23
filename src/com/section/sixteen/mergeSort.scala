package com.section.sixteen

/**
  * 归并排序 复杂度 nlog(n)
  */
object mergeSort extends App {
  def msort[T](less:(T,T) => Boolean)(xs:List[T]):List[T] = {
    def merge(xs:List[T],ys:List[T]):List[T] = (xs,ys) match {
      case (Nil,_) => ys
      case (_,Nil) => xs
      case (x::xs1,y::ys1) => if (less(x, y)) x:: merge(xs1, ys)
      else y :: merge(xs,ys1)
    }

    val n = xs.length / 2
    if (n == 0) xs
    else {
      val(ys,zs) = xs splitAt n
      merge(msort(less)(ys),msort(less)(zs))
    }
  }

  println(msort((x:Int,y:Int) => x > y) (List(5,7,1,3)))

  val intSort = msort((x:Int,y:Int) => x > y) _
  val reserveSort = msort((x:Int,y:Int) => x < y) _

  println(intSort(List(5,7,1,3)))
  println(reserveSort(List(5,7,1,3)))

}
