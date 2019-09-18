package com.epi.problems.arrays;

import com.example.util.Util;

import java.util.List;

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

    /**
     * Given an array of ints representing an integer,
     * this method increments that integer by one.
     * performing all operation directly on the array.
     * @param integer
     * @return
     */
    public static int[] incrementInteger(int[] integer){
        int carry = (integer[integer.length-1] + 1) / 10;
        integer[integer.length-1] = (integer[integer.length-1] + 1) % 10;

        int index = integer.length -2;
        while(index >= 0 && carry != 0){
            carry = (integer[index] + 1) / 10;
            integer[index] = (integer[index] + 1) % 10;
            index--;
        }

        if(carry==1){
            int[] newArray = new int[integer.length+1];
            newArray[0] = 1;
            int i = 1;
            for(int number : integer) newArray[i++] = number;
            return newArray;
        }
        return integer;
    }

    /**
     * This method implements the above algorithm in a better way.
     * @param integer
     */
    public static void incrementIntegerOptimized(List<Integer> integer){
        integer.set(integer.size()-1, integer.get(integer.size()-1)+1);
        int index = integer.size() - 1;
        while(index > 0 && integer.get(index) == 10){
            integer.set(index, 0);
            integer.set(index - 1, integer.get(index -1) + 1);
            index--;
        }
        if(integer.get(0)==10){
            integer.set(0, 0);
            integer.add(0, 1);
        }
    }

    /**
     * Solves the problem 6.4 of EPI.
     * returns true if the board game is winnable false otherwise.
     * @param array
     * @return
     */
    public static boolean solveBoardGame(int[] array){
        int maxReachableSoFar = 0;
        for(int i=0; i<array.length; i++) {
            maxReachableSoFar = Math.max(maxReachableSoFar, i + array[i]);
            if (maxReachableSoFar == i) return false;
        }
        return true;
    }

}
