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
            print("\nNo. of bits set for decimal value $testValue: $setBits")
            testValue++
        }
    }
}

fun main(){
    Runner().runBitCalculatorTest()
}