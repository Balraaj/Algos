package com.hackerrank

import kotlin.math.max

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

    /**
     * Divisible sum problem
     */
    fun divisibleSumPairs(n: Int, k: Int, ar: Array<Int>): Int {
        var map = HashMap<Int, Int>()
        var result = 0
        for(value in ar){
            var currentKey = value % k
            var matchkey = if(currentKey == 0) 0 else k - currentKey
            if(map.containsKey(matchkey)){
                result += map[matchkey]!!
            }
            var currentKeyValue = map[currentKey] ?: 0
            map[currentKey] = ++currentKeyValue
        }
        return result
    }

    /**
     * Divisible Sum pairs with array instead of map
     */
    fun divisibleSumPairsFast(n: Int, k: Int, ar: Array<Int>): Int {
        var map = IntArray(k){0}
        var result = 0
        for(value in ar){
            var currentKey = value % k
            var matchkey = if(currentKey == 0) 0 else k - currentKey
            result += map[matchkey]
            map[currentKey]++
        }
        return result
    }

    fun migratoryBirds(arr: Array<Int>): Int {
        var bird = IntArray(6)
        for(value in arr){
            bird[value]++
        }
        var maxType = 0
        for(i in 1 until arr.size){
            if(arr[i] > arr[maxType]){
                maxType = i
            }
        }
        return maxType
    }

    fun dayOfProgrammer(year: Int): String {
        if(year == 1918) return "26.09.1918"
        if(year <= 1917){
            if(year % 4 == 0) return "12.09.$year"
            else return "13.09.$year"
        }
        else if( (year % 400 == 0) || ((year % 4 == 0) && (year %100 !=0))){
            return "12.09.$year"
        }
        else{
            return "13.09.$year"
        }
    }

    /**
     * Hacker rank problem Bon Appetit
     */
    fun bonAppetit(bill: Array<Int>, k: Int, b: Int): Unit {
        var sum = 0
        for(i in bill.indices){
            if(i != k) sum+=bill[i]
        }
        sum/=2
        if(sum == b) print("Bon Appetit")
        else print(b - sum)
    }

    // 10 20 20 10 10 30 50 10 20
    fun sockMerchant(n: Int, ar: Array<Int>): Int {
        var socks = IntArray(101){0}
        var canSell = 0
        for(sock in ar){
            if(socks[sock] == 1) canSell++
            socks[sock] = (socks[sock] + 1) % 2
        }
        return canSell
    }

    fun pageCount(n: Int, p: Int): Int {
        var fromStart = p/2
        var fromEnd = n/2 - fromStart
        return if(fromStart< fromEnd) fromStart else fromEnd
    }
}