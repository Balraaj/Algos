package com.example.kotlin

class Temp{
    object Holder{
        fun foo() = 1
    }

    companion object{
        fun foo() = "Hello World"
    }

    fun test(){
        print(foo())
        print(Holder.foo())
    }
}