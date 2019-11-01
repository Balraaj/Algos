package com.epi.problems.temp;

import com.example.util.Util;

public class Temp {

    public static int countOnBits(int number){
        int onBits = 0;
        while(number != 0){
            onBits += (number & 1);
            number = number >> 1;
        }
        return onBits;
    }


    public static int swapBits(int number, int x, int y){
        int xMask = 1<<(x);
        int yMask = 1<<(y);
        if((number & xMask) != (number & yMask)){
            number = number ^ (xMask | yMask);
        }
        return number;
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
