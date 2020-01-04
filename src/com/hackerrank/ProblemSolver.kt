@file:JvmName("MyProblemSolver")
package com.hackerrank

import kotlin.math.abs
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

    fun countingValleys(n: Int, s: String): Int {
        val SEA_LEVEL = 0
        var currentLevel = 0
        var valleys = 0
        for(c in s){
            if((currentLevel == SEA_LEVEL) && (c == 'D')){
                valleys++
            }
            currentLevel = if(c == 'U') currentLevel+1 else currentLevel-1
        }
        return valleys
    }

    /** Hacker rank problem Electronics shop */
    fun getMoneySpent(keyboards: Array<Int>, drives: Array<Int>, b: Int): Int {
        drives.sort()
        var moneySpent = -1
        for(keyboard in keyboards){
            var i = search(drives, b-keyboard)
            var t = drives[i] + keyboard
            if((t>moneySpent) && (t<=b)){
                moneySpent = t
            }
        }
        return moneySpent
    }

    private fun search(arr: Array<Int>, value: Int): Int{
        if(value < arr[0]) return 0
        if(value > arr[arr.size-1]) return arr.size-1

        var low = 0
        var high = arr.size -1
        var mid = 0
        while(low <= high){
            mid = (low + high)/2
            if(arr[mid] == value) return mid
            else if(arr[mid] > value) high = mid-1
            else low = mid+1
        }
        return high
    }

    /**
     * Hacker rank problem: Climbing the leader board
     */
    fun climbingLeaderboard(scores: Array<Int>, alice: Array<Int>): Array<Int> {
        var result = Array<Int>(alice.size){0}
        var scoresEnd = shred(scores)
        for(i in alice.indices){
            result[i] = getRank(scores, scoresEnd, alice[i])
        }
        return result
    }

    /**
     *  Hacker rank problem: Climbing the leader board
     *  This solution takes into consideration the fact
     *  that alice's scores are in ascending order
     */
    fun climbingLeaderboardModified(scores: Array<Int>, alice: Array<Int>): Array<Int> {
        var end = shred(scores)
        var rank: Int
        var result = Array<Int>(alice.size){0}
        for(i in alice.indices){
            while((end >=0) && (scores[end] <= alice[i])) end--
            result[i] = end + 2
        }
        return result
    }


    private fun shred(ar: Array<Int>): Int{
        var i = 0
        for(index in 1 until ar.size){
            if(ar[index] != ar[i]){
                ar[++i] = ar[index]
            }
        }
        return i
    }

    private fun getRank(ar: Array<Int>, endIndex: Int, value: Int): Int{
        if(value > ar[0]) return 1
        if(value < ar[endIndex]) return endIndex+1

        var low = 0
        var high = endIndex
        var mid = 0
        while(low <= high){
            mid = (low + high)/2
            if(ar[mid] == value) return mid+1
            else if(ar[mid] > value) low = mid+1
            else high = mid-1
        }
        return high+2
    }

    fun catAndMouse(x: Int, y: Int, z: Int): String {
        return if((x==y) || (abs(z-x) == abs(z-y))){
            "Mouse C"
        }
        else if(abs(z-x) < abs(z-y)){
            "Cat A"
        }
        else{
            "Cat B"
        }
    }
}

fun myFun():String{
    return ""
}