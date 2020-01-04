package com.example.kotlin

class Test(private val mode: Boolean=false){


    object Sorter: Comparator<Int>{
        override fun compare(o1: Int?, o2: Int?): Int {
            if((o1 != null) && (o2 != null)){
                return o2.compareTo(o1)
            }
            else if(o1 != null) return -1
            else return 1
        }
    }

    var Sorter2 = object: Comparator<Int>{
        override fun compare(o1: Int?, o2: Int?): Int {
            if((o1 != null) && (o2 != null)){
                if(mode){
                    return o2.compareTo(o1)
                }
                else{
                    return o1.compareTo(o2)
                }

            }
            else if(o1 != null) return -1
            else return 1
        }
    }

    fun test(){
        var list = arrayListOf<Int>(3,4,1,2,89,4)
        var sorted = list.sortedWith(Sorter2)
        print(sorted)
    }

}
fun String.lastChar():Char = get(length-1)

fun checkVar(vararg values: Int){
    for(v in values)print(v)
}
fun main(){
//    var array = intArrayOf(1,2,3,45,677)
//    checkVar(*array)
//    print("Hello".lastChar())
//    Test().test()
//    Test(true).test()
//
//    println("Bmir".isNullOrEmpty())
//    println("".isNullOrEmpty())
//    var str: String? = null
//    println(str.isNullOrEmpty())
//    var x: Nothing = str.doSomething()
//    twoDList()
    collectionEx()
    Temp.foo()
    Temp.Holder.foo()
}

fun String.startsWithA(): Boolean{
    return isNotEmpty() && (this[0] == 'A')
}

fun String?.doSomething(): Nothing {
    while(true) print("a")
}

fun xyz(){
    var x = ArrayList<Int>()
    var y = IntArray(5)
}

fun twoDArray(){
    var array = Array(3){i -> IntArray(3){j-> if(i==j) 1 else 0} }
    for(i in array.indices){
        for(j in 0..2){
            print(" ${array[i][j]}")
        }
        println()
    }
}

fun twoDList(){
    var list = ArrayList<ArrayList<Int>>(3)
    for(i in 0..2){
        list.add(ArrayList<Int>(3))
    }

    for(i in 0..2){
        list[i].add(0)
        list[i].add(1)
        list[i].add(2)
    }

    for(i in 0..2){
        for(j in 0..2){
            print(" ${list[i][j]}")
        }
        println()
    }
}

fun collectionEx(){
    var list: MutableList<Int> = arrayListOf(1,2,3,4,5)
    println(list)
    mutator(list)
    println(list)

    var imlist: List<Int> = listOf(1,2,3,5)
    println(imlist)
    JavaTemp.remove(imlist)
    println(imlist)
}

fun <T: Any> mutator(list: MutableList<T>){
    var last = list[list.size-1]
    list[list.size-1] = list[0]
    list[0] = last
}