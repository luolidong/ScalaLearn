package com.section.thirteen.bobsdelights

class Fruits ( name:String,color:String ) {

}
object Fruits {
  object Apple extends Fruits("apple","red")
  object Orange extends Fruits("orange","orange")
  object Pear extends Fruits("pear","yellowish")
  val menu = List(Apple,Orange,Pear)
}
