package com

fun main(){
    var cls = helloclass()
    var cls2 = helloclass(1)
    println(cls2.age)

    var person = daclass(1, "mari")
    println(person.name)

}

class helloclass{
    var age:Int = 0
    init{

    }

    constructor()
    constructor(age: Int){
        this.age = age
    }
}

data class daclass(var age:Int, val name:String)