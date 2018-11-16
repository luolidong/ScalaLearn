package com.section.seven

/**
  * 内建控制结构
  * 1 If while do...while  For
  * 2 try 处理异常
  * 3 finally 避免在funally子句返回值
  * 4 match 与Java的switch相比，match表达式能产生值
  */
object run extends App {
  // 1 2 3 4
  for (i <- 1 to 4)
    print(i)
  println()
  //1 2 3
  for (i <- 1 until 4)
    print(i)
  println()

  //5 6 7 8
  val arr = Array(1,2,3,4,5,6,7,8,9)
  println(for (i<- 0 until arr.length if (i >= 4 && i <=7)) yield arr(i))

  //返回2
  def f() : Int = try {return 1} finally {return 2}

  //返回1
  def g() : Int = try { 1 } finally {2}

  println(f())
  println(g())


  val firstArg = if (true) "sal1t" else "eggs"
  val friend =
    firstArg match {
      case "salt" => "pepper"
      case "chipes"=> "salsa"
      case "eggs" => "bacon"
      case _ => "huh?"
    }
  println(friend)


}
