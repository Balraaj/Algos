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

    /**
     * EPI 12.3: Find rotation point of a sorted rotated array containing distinct elements.
     */

    fun findRotationPoint(array: Array<Int>): Int{
        var low = 0
        var high = array.size -1
        var mid: Int

        while(array[low] > array[high]){
            mid = low +(high-low)/2
            when{
                array[mid] > array[high] ->  low = mid + 1
                else -> high = mid
            }
        }
        return low
    }

    /**
     * EPI: 12.3: Variant: A sequence is strictly ascending
     * if each element is greater than its predecessor.
     * Suppose it is known that an array A consists of a strictly ascending sequence
     * followed by a strictly descending sequence.
     * Design an algorithm for finding the maximum element in A.
     */
    fun findMaxInBellCurve(array: Array<Int>): Int{
        /** Handle the edge cases */
        if (array.isEmpty()) return -1
        if (array.size ==1) return 0
        if (array.size ==2) return if(array[0] > array[1]) 0 else 1

        var start = 0
        var end = array.size -1
        var mid: Int
        while(start<=end){
            mid = start + (end-start)/2
            if((array[mid]>array[mid-1]) && (array[mid]<array[mid+1])){
                start = mid+1
            }
            else if((array[mid]>array[mid-1]) && (array[mid]>array[mid+1])){
                return mid
            }
            else {
                end = mid-1
            }
        }
        return -1
    }

    /**
     * EPI: 12.3: Variant: 2
     */
    fun findKInSortedRotatedArray(array: Array<Int>, k: Int): Int {
        var start = 0
        var end = array.size-1
        var mid: Int
        while(start<=end){
            mid = start + (end-start)/2
            if(array[mid] == k) return mid
            else if((array[start]<=k) && (array[mid]>k)){
                end = mid-1
            }
            else{
                start = mid+1
            }
        }
        return -1
    }
}