package com.example.practice.problems;

import java.util.ArrayList;
import java.util.List;

public class KClosest {
    private static int getClosest(int[] array, int value){
        if(value<array[0]) return 0;
        if(value>array[array.length-1]) return array.length-1;

        int start = 0;
        int end = array.length-1;
        int mid;
        while(start<end){
            mid = (start+end)/2;
            if(array[mid]==value) return mid;
            if(array[mid]<value) start = mid+1;
            if(array[mid]>value) end = mid -1;
        }

        return ((array[start]-value)<value-array[end])?start:end;
    }


    public static List<Integer> getKClosest(int[] array, int value, int k){
        List<Integer> kClosest = new ArrayList<>();
        int index = getClosest(array,value);
        int lower = (array[index]==value)?index-1:index;
        int upper = (lower==index)?index+1:index+2;
        int i = 0;
        while((i<k) && ((lower>=0) && (upper<array.length))){
            int lowerDiff = value - array[lower];
            int upperDiff = array[upper] - value;
            if(lowerDiff < upperDiff){
                kClosest.add(array[lower]);
                lower--;
            }
            else{
                kClosest.add(array[upper]);
                upper++;
            }
            i++;
        }

        while((i<k)&&(lower>=0)){
            kClosest.add(array[lower]);
            i++;
            lower--;
        }
        while((i<k)&&(upper<array.length)){
            kClosest.add(array[upper]);
            i++;
            upper++;
        }

        return kClosest;
    }


    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9,10,14};
        System.out.print(getKClosest(array,0,3));
    }
}
