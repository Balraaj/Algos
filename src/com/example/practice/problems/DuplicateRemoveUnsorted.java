package com.example.practice.problems;

import com.example.util.Util;

import java.util.HashSet;

/**
 * Given an unsorted array remove all the duplicate elements
 */
public class DuplicateRemoveUnsorted {

    public static int removeDuplicates(int[] array){
        HashSet<Integer> set = new HashSet<>();
        int i=0;
        int j=0;
        while(i<array.length){
            if(!set.contains(array[i])){
                set.add(array[i]);
                array[j++] = array[i];
            }
            i++;
        }

        return j;
    }

    public static void main(String[] args){
        int[] array = {0,1,2,3,4,5,0,1,2,3,4,5,6};
        System.out.print("\nBefore duplicate removal ");
        Util.printArray(array);
        int newLength = removeDuplicates(array);
        System.out.print("\nAfter duplicate removal ");
        Util.printArray(array, newLength);
    }
}
