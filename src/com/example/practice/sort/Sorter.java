package com.example.practice.sort;

import com.example.util.Util;

public class Sorter {

    public static int[] bubbleSort(int[] array){
        int length = array.length;
        for(int i=0; i<length-1; i++){
            boolean flag = false;
            for(int j=0; j<length-1;j++){
                if(array[j]>array[j+1]){
                    flag = true;
                    Util.swap(array, j,j+1);
                }
            }
            if(!flag) break;
        }
        return array;
    }

    public static int[] selectionSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            int minElementIndex = i;
            for(int j=i; j<array.length;j++){
                if(array[j]<array[minElementIndex]){
                    minElementIndex = j;
                }
            }
            Util.swap(array,i,minElementIndex);
        }
        return array;
    }

    public static int[] insertionSort(int[] array){
        for(int i=1;i<array.length;i++){
            int currentElement = array[i];
            int j = i-1;
            while((j>=0) && (array[j]>currentElement)){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = currentElement;
        }
        return array;
    }


}
