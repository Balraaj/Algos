package com.example.util;

import com.example.practice.problems.LinkedList;

public class Util {

    public static void swap(int[] array, int firstPosition, int secondPosition){
        int temp = array[firstPosition];
        array[firstPosition] = array[secondPosition];
        array[secondPosition] = temp;
    }

    public static void printArray(int[] array){
        for(int value : array){
            System.out.print(value+" ");
        }
    }

    public static void print2dArray(int[][] array){
        int n = array.length;
        int m = array[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
