package com.epi.problems

/**
 * This class contains runners for different
 * problem solver methods.
 */

class Runner{

    fun runMaxProfit(){
        var prices = arrayOf(1.6,23.0,123.0,5.0,150.0)
        var maxProfit = ProblemSolver.calculateMaxProfit(prices)
        print("Max profit is : $maxProfit")
    }

    fun runBitCalculatorTest(){
        var testValue = 0
        while(testValue < 129){
            var setBits = BitManipulator.calculateSetBits(testValue)
            var parity = BitManipulator.calculateParityFast(testValue)
            print("\n(Set bits, parity) for $testValue: $setBits, $parity")
            testValue++
        }
    }

    fun tester(){
        print("All tests passed: ${testParityCheckers()}")
    }

    fun testParityCheckers(): Boolean{
        var testValue = 0
        while(testValue < 129){
            var pSlow = BitManipulator.calculateParitySlow(testValue)
            var pFast = BitManipulator.calculateParityFast(testValue)
            if(pSlow != pFast) return false
            testValue++
        }
        return true
    }
}

fun main(){
    print(BitManipulator.swapBits(16, 4, 1))
}