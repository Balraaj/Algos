package com.example.kotlin.sorting

import com.example.util.Util

/**
 * Most basic of all the comparison based sorts.
 * Idea is that iteratively find the smallest element in the list
 * and then place it at correct position.
 *
 * Iteration only has to be done n-1 times, as last item is the largest
 * and is already at correct location.
 *
 * its in place but not stable.
 *
 * best, average and worst case is O(n^2)
 * comparisons are O(n^2)
 * swaps are O(n)
 */
fun IntArray.selectionSort(){
    var minIndex: Int
    for(i in 0..this.size-2){
        minIndex = i
        for(j in i+1 until this.size){
            if(this[j] < this[minIndex]){
                minIndex = j
            }
        }
        if(minIndex != i){
            Util.swap(this, i, minIndex)
        }
    }
}

/**
 * Do n-1 iterations over the list, in each iteration compare
 * adjacent elements, if they are out of order then swap them
 *
 * best case: O(n), when list is already sorted
 * average and worst case: O(n^2)
 *
 * will make more swaps when compared to selection sort
 */
fun IntArray.bubbleSort(){
    var swap: Boolean
    for(i in 0..this.size-2){
        swap = false
        for(j in 0..this.size-2-i){
            if(this[j] > this[j+1]){
                Util.swap(this, j, j+1)
                swap = true
            }
        }
        if(!swap){
            println("\nArray found sorted after $i iteration, exiting\n")
            return
        }
    }
}

/**
 * This comparison sort is stable and in place.
 * maintains two lists, one sorted and another unsorted.
 *
 * Do n-1 iterations over the list, in each iteration pick fist
 * element from unsorted list and place it in sorted list at its
 * correct location.
 *
 * best case: list is already sorted: O(n)
 * average and worst case: O(n^2)
 */
fun IntArray.insertionSort(){
    for(i in 1 until this.size-1){
        var key = this[i]
        var j = i-1
        while((j>0) && (this[j] > key)){
            this[j+1] = this[j--]
        }
        this[j+1] = key
    }
}

/**
 * Comparison based sort based on divide and conquer.
 * divides the input into two equal parts, sort them recursively
 * and then merge two sorted lists into single list.
 *
 * Its stable but not in place, merge procedure requires extra space.
 * best, average and worst case: O(nlogn)
 */
fun mergeSort(array: IntArray, start: Int, end: Int){
    if(start<end){
        var mid = (start + end) / 2
        mergeSort(array, start, mid)
        mergeSort(array, mid+1, end)
        merge(array, start, mid, end)
    }
}

private fun merge(array: IntArray, start: Int, mid: Int, end: Int){
    var arr1 = IntArray(mid-start+1)
    var arr2 = IntArray(end-mid)

    var i = start
    var j = mid+1
    for(k in arr1.indices) arr1[k] = array[i++]
    for(k in arr2.indices) arr2[k] = array[j++]

    i = 0
    j = 0
    var k = start
    while((i<arr1.size) && (j<arr2.size)){
        if(arr1[i] < arr2[j]) array[k] = arr1[i++]
        else array[k] = arr2[j++]
        k++
    }

    while(i<arr1.size) array[k++] = arr1[i++]
    while(j<arr2.size) array[k++] = arr2[j++]
}

/**
 * Comparison based sort based on divide and conquer.
 * in the input list pick an element as pivot,
 * and then rearrange the list such that elements smaller
 * to pivot come left and element greater then pivot come right.
 *
 * then recursively sort the input from start to pivot-1,
 * and pivot+1 to end.
 *
 * It is in place but not stable.
 *
 * best and average case: O(nlogn)
 * worst case: O(n^2)
 */
fun quickSort(array: IntArray, start: Int, end: Int){
    if(start<end){
        var pivot = partition(array, start, end)
        quickSort(array, start, pivot-1)
        quickSort(array, pivot+1, end)
    }
}

private fun partition(array: IntArray, start: Int, end: Int): Int{
    var swapIndex = start
    for(i in start until end){
        if(array[i] < array[end]){
            Util.swap(array, i, swapIndex++)
        }
    }
    Util.swap(array, swapIndex, end)
    return swapIndex
}


fun main(args: Array<String>){
    var array = IntArray(10){i -> i}
    println(array.asList())
    quickSort(array, 0, array.size-1)
    println(array.asList())
}