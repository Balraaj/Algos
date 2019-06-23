package com.example.util;

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
}
