package com.epi.problems

object BitManipulator{

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

    /**
     * This method calculates the parity of given integer
     * by iterating over all the bits
     */
    fun calculateParitySlow(value: Int): Int{
        var number = value
        var parity = 0
        while(number != 0){
            parity = parity.xor(number and 1)
            number = number.ushr(1)
        }
        return parity
    }

    /**
     * A fast method to calculate the parity then plain brute force approach.
     * it only iterates k number of times where k is the number of set bits.
     */
    fun calculateParityFast(value: Int): Int{
        var number = value
        var parity = 0
        while(number != 0){
            parity = parity.xor(1)
            number = number.xor(number and (number -1).inv())
        }
        return parity
    }

    /**
     * This method swaps two bits a number given by x and y.
     * we observe that swapping is only required if both the bits differ.
     */
    fun swapBits(number: Long, x: Int, y: Int): Long{
        if(((number shr x) and 1) != ((number shr y) and 1)){
            var bitMask = (1L shl x) or (1L shl y)
            return number.xor(bitMask)
        }
        return number
    }
}
