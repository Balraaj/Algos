package com.example.practice.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two sorted lists, print the values in increasing order.
 */
public class MergeSortedLists {
    public static List<Integer> getIncreasing(int[] array1, int[] array2){
        List<Integer> result = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;

        while((index1<array1.length) && (index2<array2.length)){

            if(array1[index1]<array2[index2]){
                result.add(array1[index1]);
                index1++;
            }
            else{
                result.add(array2[index2]);
                index2++;
            }
        }

        while(index1<array1.length) result.add(array1[index1++]);
        while(index2<array2.length) result.add(array2[index2++]);
        return result;
    }

    public static void main(String... args){
        int[] arr1 = {-2,3,4,6,8,8,8,8};
        int[] arr2 = {2,4,6,8,10,12,13,14,15};
        System.out.print(getIncreasing(arr1,arr2));
    }
}
