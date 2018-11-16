package com.section.ten

/**
  * 组合和继承
  * 1 无参数方法可以省去参数括号
  * 2 扩展类 extends
  * 3 多态
  * 4 继承会造成脆基类的问题：最后一种情况是易违约基类问题的体现，超类的修改无法在不检查所有子类的前提下被验证。
  *                         假定程序员Alice定义了一个Person类，在Alice完全不知情的情况下，程序员Bob定义了一个子类Student，
  *                         和一个名为id的方法，返回学生ID。后来，Alice也定义了一个id方法，对应该人员的全国范围的ID。
  *                         当Bob拿到这个修玫后，Bob的程序可能会出问题，但在Alice的测试案例中不会有问题，
  *                         因为Student对象返回的不再是预期的那个ID了。
  * 5 final: 声明类，则不会有子类；什么成员，则不会被子类重写
  * 6 动态绑定
  * 7 虚类
  */


// 若不初始化变量则必须声明为虚类
abstract class Element {
  val width:Int
  val height:Int
  def demo(): Unit = {
    println("this demo")
  }
}
/**
  * extends 子句的2个效果：
  * 1 ArrayElement继承Element类的所有非私有的成员。并且让ArrayElement类型成为Element类型的子类，Element是ArrayElement的超类
  * 2 继承表示超类的所有成员也是子类的成员，除了2种情况：第一，超类的私有成员不会被子类继承。第二，超类中的成员若与子类中实现的成员具有相同的名称和参数，则不会被继承
  * 3 scala禁止在同一个类里用同样的名称定义字段和方法
  * */
class ArrayElement(conts:Array[String]) extends Element {
  def contents:Array[String] = conts

   override def demo():Unit = {
    println("this is ArrayElement")
  }

  override val width: Int = _
  override val height: Int = _
}


/**
  * 子类调用父类构造器，字需要简单的把传递的参数或者参数列表放到超类名之后的括号
  * */
class ListElement(s:String) extends ArrayElement(Array(s)) {
  override val width = s.length

  override def demo():Unit ={
  println("this is ListElement")
  }
}

class UniformElent(ch: Char,override val width:Int,override val height: Int)
  extends Element {
  private val line = ch.toString * width
//  def contents = Array.make(height,line)

}

object run {

  def main(args: Array[String]): Unit = {
    def getconfig:Int = 3

//    val getconfig = 1

    println(getconfig)

    val listElement = new ListElement("hello")
    listElement.contents.foreach(println(_))

    val uniformElent = new UniformElent
    uniformElent.invokeDemo(uniformElent)
    uniformElent.invokeDemo(new ArrayElement(Array("")))
    uniformElent.invokeDemo(new ListElement("hello"))
  }
}
