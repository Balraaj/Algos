package com.example.practice.problems;

import com.example.util.Util;

/**
 * Given a sorted array remove all the duplicate elements
 */
public class DuplicateRemoveSorted {

    public static int removeDuplicates(int[] array){
        int i = 0;
        int j = 0;

        while(i<array.length){
            array[j++] = array[i];
            while((i<array.length-1)&&(array[i]==array[i+1])) i++;
            i++;
        }

        /* Return the new length of array, it may be less then the original */
        return j;
    }

    public static void main(String[] args){
        int[] array = {-1,-1,-1,0,0,0,1,1,1,1,2,3,4,5,6,7,8,9,9,9,9,9,9,10,10};
        System.out.print("\nBefore duplicate removal ");
        Util.printArray(array);
        int newLength = removeDuplicates(array);
        System.out.print("\nAfter duplicate removal ");
        Util.printArray(array, newLength);
    }
}
