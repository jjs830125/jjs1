package com

fun main(){
    val hello1 = "Hell0 world1"  //final
    var hello2: String? = null  //String
    hello2 = null  //String
    hello2 = null  //String
    hello2(hello1)
}

fun hello1(){ //void

}

fun hello2(aaa: String): String{
    return println(aaa).toString()
}