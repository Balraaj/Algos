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
}