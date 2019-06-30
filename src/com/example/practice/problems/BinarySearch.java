package com.example.practice.problems;

public class BinarySearch {
    public static int findIterative(int[] array, int value){
        int start = 0;
        int end = array.length-1;
        int mid;
        while(start<=end){
            mid = (start+end)/2;
            if(array[mid]==value) return mid;
            if(array[mid]>value) end = mid-1;
            if(array[mid]<value) start = mid+1;
        }
        return -1;
    }

    public static int findRecursive(int[] array, int value, int start, int end){
        if(start<=end){
            int mid = (start+end)/2;
            if(array[mid]==value){
                return mid;
            }
            else if(array[mid]>value){
                return findRecursive(array,value,start,mid-1);
            }
            else{
                return findRecursive(array,value,mid+1,end);
            }
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9};
        System.out.print(findRecursive(array,9,0,array.length-1));
    }
}
