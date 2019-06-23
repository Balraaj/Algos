package com.example.practice.sort;

import com.example.util.Util;

public class HeapSort {

    public static int[] sort(int[] array){

        buildHeap(array);

        for(int i= array.length-1;i>0;i--){
            Util.swap(array,0,i);
            heapify(array,0,i);
        }
        return array;
    }

    public static void buildHeap(int[] array){
        int startIndex = array.length/2;
        while(startIndex>=0){
            heapify(array,startIndex--,array.length);
        }
    }

    public static void heapify(int[] array, int index, int heapSize){
        int leftChild = index*2+1;
        int rightChild = index*2+2;

        int maxElement = index;
        if((leftChild<heapSize)&&(array[leftChild]>array[maxElement])){
            maxElement = leftChild;
        }
        if((rightChild<heapSize)&&(array[rightChild]>array[maxElement])){
            maxElement = rightChild;
        }

        if(maxElement!=index){
            Util.swap(array,index,maxElement);
            heapify(array,maxElement,heapSize);
        }
    }
}
