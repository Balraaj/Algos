package com.epi.problems.random;

import com.example.util.Util;

public class Runner {

    public static void main(String[] args){
        int[] first = {1,1,1,2,3,6,9,15,4,4,4,4,2,7,8,8,84,4};
        int[] second = {1,6,8,9,12,14,15,56};
        arrangeEvensInBeggining(first);
        Util.printArray(first);
    }


    public static void arrangeEvensInBeggining(int[] array){
        int start = 0;
        int end = array.length-1;
        while(start < end){
            while((start<end) && (array[start] %2 == 0)) start++;
            while((start<end) && (array[end] %2 != 0)) end--;
            if(start<end) Util.swap(array, start, end);
        }
    }
}
