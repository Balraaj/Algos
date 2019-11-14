package com.epi.problems.search

object ProblemSolver{

    /**
     * EPI 12.1: Given a sorted array find the first
     * index of element k, if it exists.
     */
    fun findFirstK(array: Array<Int>, k: Int): Int{
        var left = 0
        var right = array.size-1
        var result = -1
        while(left <= right){
            var mid = left+((right-left)/2)
            if(array[mid] == k) {
                result = mid
                right = mid -1
            }
            else if(array[mid] < k) left = mid+1
            else right = mid-1
        }
        return result
    }

    /**
     * EPI 12.1: Variant 1: Design an efficient algorithm that takes a sorted array and a key, and finds
     * the index of the first occurrence of an element greater than that key.
     */
    fun findFirstMGreaterThenK(array: Array<Int>, k: Int): Int{
        if(array.isEmpty() || array[array.size-1] <= k) return -1
        if(array[0] > k) return 0

        var low = 0
        var high = array.size-1
        var mid: Int
        var result = -1

        while(low <= high){
            mid = low + (high-low) / 2
            when {
                array[mid] > k -> high = mid - 1
                array[mid] == k -> {
                    result = mid
                    low = mid + 1
                }
                else -> low = mid + 1
            }
        }

        /* Result is pointing to the last occurrence of k */
        return result + 1
    }

    /**
     * EPI 12.2: Design an efficient algorithm that takes a sorted array of distinct integers, and returns
     * an index i such that the element at index i equals i.
     */
    fun findKEqualToIndex(array: Array<Int>): Int{
        var low = 0
        var high = array.size -1
        var mid: Int

        while(low <= high){
            mid = low +(high - low)/2
            when{
                array[mid] > mid -> high = mid -1
                array[mid] == mid -> return mid
                else -> low = mid + 1
            }
        }
        return -1
    }
}