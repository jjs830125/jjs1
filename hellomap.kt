package com

fun main(){
    //map - key ,value pair
    var map = mapOf(Pair("name","mari"))
    var map2 = mutableMapOf<String,String>()
    map2.put("name","rima")
    map2.put("age","19")

    map2.remove("name")
    println(map2)

    println(if(!map2.containsKey("name")){"0"}else{map2.getValue("name")})
}