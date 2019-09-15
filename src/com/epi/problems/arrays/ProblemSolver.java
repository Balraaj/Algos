package com.epi.problems.arrays;

import com.example.util.Util;

/**
 * A utility class for the solutions of problems
 * which doesn't warrant an individual class
 */
public class ProblemSolver {

    /**
     * This method reorders the array so that all the even numbers
     * come before the odd numbers.
     * @param array
     */
    public static void evenOdd(int[] array){
        int swapCandidate = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] %2 == 0){
                Util.swap(array, swapCandidate, i);
                swapCandidate++;
            }
        }
    }

    /**
     * Rearranges the given array such that all the elements less then array[pivot]
     * come first followed by all the elements equal to array[pivot] and then
     * all the elements greater then array[pivot]
     * @param array
     * @param pivot
     */
    public static void dutchFlag(int[] array, int pivot){
        int swapCandidate = 0;
        int pivotValue = array[pivot];
        while(array[swapCandidate]<pivotValue) swapCandidate++;

        for(int i=swapCandidate; i<array.length; i++){
            if(array[i] < pivotValue){
                Util.swap(array, i , swapCandidate);
                swapCandidate++;
            }
        }

        for(int i=swapCandidate; i<array.length; i++){
            if(array[i] == pivotValue){
                Util.swap(array, i, swapCandidate);
                swapCandidate++;
            }
        }
    }

    /**
     * This method solves the dutchFlag problem in a single pass.
     * to solve the problem we divide the array into 4 sections.
     * and maintain counters smaller, equal and larger to mark the
     * boundaries of these sections.
     * @param array
     * @param pivot
     */
    public static void dutchFlagSinglePass(int[] array, int pivot){
        int equal = 0;
        int smaller = 0;
        int larger = array.length-1;

        while(equal <= larger){
            if(array[equal] < pivot){
                Util.swap(array, equal++, smaller++);
            }
            else if(array[equal] == pivot){
                equal++;
            }
            else{
                Util.swap(array, equal, larger--);
            }
        }
    }

}
