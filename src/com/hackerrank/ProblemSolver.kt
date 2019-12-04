package com.hackerrank

object ProblemSolver{

    /**
     * Problem: Birthday Chocolate
     */
    fun birthday(s: Array<Int>, d: Int, m: Int): Int {
        if(s.size < m) return 0
        var result = 0
        var sum = 0
        for(i in s.indices){
            sum = if(i<m) sum+s[i] else sum - s[i-m] + s[i]
            if(i >= m-1 && sum == d) result++
        }
        return result
    }

    fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
        var lcm1 = lcm(a)
        var gcd2 = gcd(b)
        var totalX = 0
        var lcm2 = lcm1
        while(lcm2 <= gcd2){
            if(gcd2 % lcm2 == 0) totalX++
            lcm2 += lcm1
        }
        return totalX
    }

    /**
     * *************** Helper functions for get total x *******************
     */
    private fun gcd(array: Array<Int>): Int{
        if(array.size == 1) return array[0]
        var gcd = array[0]
        for(i in 1 until array.size){
            gcd = if(array[i] > gcd){
                gcd(array[i], gcd)
            }
            else{
                gcd(gcd, array[i])
            }
        }
        return gcd
    }

    private fun gcd(n1: Int, n2: Int): Int{
        if(n2 == 0) return n1
        return gcd(n2, n1 % n2)
    }

    private fun lcm(array: Array<Int>): Int{
        if(array.size == 1) return array[0]
        var lcm = array[0]
        for(i in 1 until array.size){
            var gcd = if(lcm > array[i]) gcd(lcm, array[i]) else gcd(array[i], lcm)
            var localLcm = (lcm * array[i])/gcd
            lcm = if(lcm > localLcm) lcm else localLcm
        }
        return lcm
    }

}