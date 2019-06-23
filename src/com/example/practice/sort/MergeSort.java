package com.example.practice.sort;

import java.util.Arrays;

public class MergeSort {
    public static int[] sort(int[] array, int start, int end){
        if(start<end){
            int mid = (start+end)/2;
            sort(array,start,mid);
            sort(array,mid+1,end);
            merge(array,start,mid,end);
            return array;
        }
        return array;
    }

    private static void merge(int[] array, int start, int mid, int end){
        int[] array1 = Arrays.copyOfRange(array,start,mid+1);
        int[] array2 = Arrays.copyOfRange(array,mid+1,end+1);

        int x = 0;
        int y = 0;
        int z = start;

        while((x<array1.length) && (y<array2.length)){
            if(array1[x]<array2[y]){
                array[z] = array1[x];
                x++;
                z++;
            }
            else{
                array[z] = array2[y];
                y++;
                z++;
            }
        }

        while(x<array1.length){
            array[z++] = array1[x++];
        }
        while(y<array2.length){
            array[z++] = array2[y++];
        }
    }
}
