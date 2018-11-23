package com.section.sixteen


/**
  * 使用列表
  * 1 所有列表都是由两个基础构造快Nil和::构造出来的
  * 2 列表的基本操作 head tail isEmpty
  */
object run extends App{
    // 列表创建
    val nums = 1 :: (2 :: 3 :: 4 :: 5 :: Nil)

    //列表模式
    val a :: b :: rest = nums
    println(a)
    println(b)
    println(rest)

    //链接列表
    val nums2 = List(1, 2, 3) ::: List(4, 5, 6)
    println(nums2)

    // 计算列表长度：length 比较耗时
    nums2.length

    // head tail init last reverse
    println(nums2.head) // 1
    println(nums2.tail) // List(2, 3, 4, 5, 6)
    println(nums2.init) // List(1, 2, 3, 4, 5)
    println(nums2.last) // 6
    println(nums2.reverse) // List(6, 5, 4, 3, 2, 1)

    //前缀和后缀： take drop splitAt
    println(nums2.take(3)) //List(1, 2, 3)
    println(nums2.drop(3)) //List(4, 5, 6)
    println(nums2.splitAt(3)) // 拆分列表  (List(1, 2, 3),List(4, 5, 6))

    //元素选择apply和indices
    nums2.apply(3) // 相当于(nums2 drop n).head  nums2(n)花费的时间与索引值n成正比

    println(nums2.indices) //返回列表的有效索引值  Range(0, 1, 2, 3, 4, 5)

    // zip 组成一个对偶列表。若长度不一致，则丢掉不匹配元素
    val abcd = List('a', 'b', 'c', 'd')
    println(abcd zip nums2) // List((a,1), (b,2), (c,3), (d,4))

    // 显示列表：toString 和 mkString
    println(abcd.toString)
    println(abcd.mkString(","))
    println(abcd.mkString("(", ",", ")"))

    //转换列表 elements toArray copyToArray
    println(nums2.toArray)
    println(nums2.toArray.toList)
    val nums2A = nums2.toArray
    nums2A.foreach(print(_))
    println()

    val toarr = new Array[Int](10)
    println(toarr.toList)
    nums2.toArray copyToArray(toarr, 0)      //把nums2的元素复制到toarr，从第0个位置开始
    println(toarr.toList)

  // map
  println(toarr.toList.map(_ + 1))

  // flatMap
  val words = List("hello","world")
  println(words.flatMap(_.toList))

  println(List.range(1,5))
  println(List.range(1,1))
  println(List.range(1,5) flatMap {
    i => List.range(1,i) map {j => (i,j)}
  })

  println(for (i <- List.range(1,5); j<- List.range(1,i)) yield (i,j))

  // 列表过滤 filter,partition,find,takewhile,dropWhile span

}
