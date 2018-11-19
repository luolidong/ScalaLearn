package com.section.fifteen

/**
  * 样本类和模式匹配
  * 1 带有case修饰符的类称为样本类
  * 2 样本类能省去new关键字
  * 3 样本类参数列表中的参数隐式活得val的前缀
  * 4 样本类便利的代价是因为产生了附加的方盒和添加了隐含的字段。不过最大的好处是支持模式匹配
  * 5 小写字母开始的简单名被当作模式变量；所有其他的引用被认为是常量
  * 6 构造器模式，深度匹配，检查对象还检查构造器参数值
  * 7 序列模式
  * 8 元组模式
  * 9 类型模式,类型测试 isinstanceof，类型转换 asinstanceof
  * 10 类型擦除：和Java一样，类型参数信息没有保留到运行期。唯一的例外是数组Array
  */

abstract class Expr
class Var2(name:String) extends  Expr
case class Var(name:String) extends  Expr
case class Number(num:Double) extends Expr
case class UnOp(operator:String,arg:Expr) extends Expr
case class BinOp(operator:String,left:Expr,right:Expr) extends Expr



object run extends  App {
  val v = Var("x")
  val v2 = new Var2("x")

  println(v.name)
//  println(v2.name)      //报错

  def simplifyTop(expr:Expr):Expr = expr match  {
    case UnOp("-",UnOp("-", e)) => println("111");e
    case BinOp("+",e,Number(0)) => println("222");e
    case BinOp("*",e,Number(1)) => println("333");e
    case _ => println("444");expr
  }


  println(simplifyTop(UnOp("-",UnOp("-",Var("x")))))

  // 匹配开始于零的三元素列表模式
  v match  {
    case List(0,_,_) => println("found it")
    case _ =>
  }

  // 匹配开始于零到任务数量的元素
  v match {
    case List(0,_*) => println("found it")
    case _ =>
  }

  def generalSize2(x:Any) = x match {
    case (a,b,c) => println("found it")
    case _=>
  }


  def generalSize(x:Any) = x match {
    case s:String => println("String")
    case m:Map[_,_] => println("Map")
  }

  def isInstanceMap(x:Any) = x match {
    case m:Map[Int,Int] => true
    case _=> false
  }

  def isInstanceArray(x:Any) = x match {
    case m:Array[Int] => true
    case _=> false
  }

  println(isInstanceMap(Map(1->1)))   //true
  println(isInstanceMap(Map("1"->1)))  //true
  println(isInstanceArray(Array(1)))  //true
  println(isInstanceArray(Array("1")))  //true
}
