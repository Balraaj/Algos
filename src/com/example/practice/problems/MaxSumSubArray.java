package com.example.practice.problems;


/**
 * Given an array of integers find the sub array with maximum sum
 */
public class MaxSumSubArray {

    public static void find(int[] arr){
        int globalStart = 0;
        int globalEnd = 0;
        int globalMax = arr[0];
        int localStart = 0;
        int localMax = 0;

        for(int i=0;i<arr.length;i++){
            localMax = localMax+arr[i];
            if(localMax>globalMax){
                globalMax = localMax;
                globalStart = localStart;
                globalEnd = i;
            }
            if(localMax<=0){
                localMax = 0;
                localStart = i+1;
            }
        }
        System.out.println("Maximum sum sub array: START: "+globalStart);
        System.out.println("Maximum sum sub array: END: "+globalEnd);
        System.out.println("Maximum sum sub array: SUM: "+globalMax);

    }

    public static void main(String[] args){
        int[] arr = {1,2,3,-3,-3,9,-10,2};
        find(arr);
    }

}
