package com.example.practice.sort;

import com.example.util.Util;

public class QuickSort {

    public static int[] sort(int[] array, int start, int end){
        if(start<end){
            int pivot = partition(array, start, end);
            sort(array, start, pivot-1);
            sort(array,pivot+1, end);
        }
        return array;
    }

    private static int partition(int[] array, int start, int end){
        int pivot = array[end];
        int index = start;
        for(int i=start;i<end;i++){
            if (array[i]<pivot) {
                Util.swap(array,i,index);
                index++;
            }
        }
        Util.swap(array,index,end);
        return index;
    }
}
