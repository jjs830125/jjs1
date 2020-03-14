package com

fun main(){
    var arr1 = listOf("1","2")
    var arr2 = mutableListOf("1","2")

    for(i in arr1){
        println(i)
    }

    for((ind,i) in arr2.withIndex()){
        println("$ind,$i")
    }

    var mari: Any = "orenomari"
    if(mari is String){
        var rima: String = mari
        println(rima)
    }
}