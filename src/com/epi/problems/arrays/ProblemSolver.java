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

}
