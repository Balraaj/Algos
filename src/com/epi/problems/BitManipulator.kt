package com.epi.problems

class BitManipulator{
companion object {

    /**
     * Brute force approach, iterates over all the bits
     * and increases count whenever last bit is found set.
     * uses unsigned right shift.
     */
    fun calculateSetBitsBruteForce(value: Int): Int{
        var setBits = 0
        for(n in 0..31){
            if(((value.ushr(n)) and 1) == 1){
                setBits++
            }
        }
        return setBits
    }

    fun calculateSetBitsSimple(value: Int): Int{
        var numberOfBits = 0
        var number = value
        while(number != 0){
            numberOfBits += (number and 1)
            number = number.ushr(1)
        }
        return numberOfBits
    }

    /**
     * This method uses the observation that to find the least significant set
     * bit of an integer the expression n & (!(n-1)) can be used.
     */
    fun calculateSetBits(value: Int): Int{
        var number = value
        var setBits = 0
        while(number != 0){
            number = number.xor(number and (number-1).inv())
            setBits++
        }
        return setBits
    }
}
}
