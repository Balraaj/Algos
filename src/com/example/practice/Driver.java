package com.example.practice;

import com.example.practice.problems.Binomial;
import com.example.practice.problems.Fibonacci;
import com.example.practice.sort.HeapSort;
import com.example.util.Util;

public class Driver {

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            for(int j=0;j<=i;j++){
                Binomial.getNCR(i,j);
            }
        }
    }

    private static int[] getArray(){
        int[] array = new int[10];
        for(int i=0,j=1;i<10;i++,j--){
            array[i]=j;
        }
        return array;
    }

    private static void sortDemo(){
        int[] array = {2,3,4,-9,67,1,-88,-999,123,1234};
        //array=getArray();
        System.out.println("Array before sorting: ");
        Util.printArray(array);
        System.out.println("\nArray after sorting: ");
        Util.printArray(HeapSort.sort(array));
    }
}
