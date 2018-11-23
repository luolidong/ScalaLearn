package com.section.test

/**
  * Created by dell on 2018/11/23.
  */
object run extends App {
  val url1 = "http://www.baidu.com?a=100&b=200&c=300"
  val url2 = "http://www.baidu.com?b=200&a=100&c=300"

  val regex = "(.*)\\?(.*)".r

  val regex(url,param1) = url2
  println(url)
  println(param)

  val list = url1.split("\\?").toList
  val param = list match {
    case List(url,param) => param
  }
  print(param)

  val paramlist = param.split("&").toList

  def getb(paramList:List[String]) : String = {
    paramList match {
      case head::tail => if (head.split("=")(0) == "b") head.split("=")(1) else getb(tail)
    }
  }

  println(getb(paramlist))
}
