package com.epi.problems.random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProblemSolver {

    /**
     * EPI: 14.1: Given two sorted arrays, return a new array
     * which contains all the elements that exist in both the arrays.
     * @param A
     * @param B
     * @return
     */
    public static List<Integer> computeIntersection(int[] A, int[] B){
        List<Integer> result = new ArrayList<>();
        int i=0;
        int j=0;
        while((i<A.length) && (j<B.length)){
            if((A[i] == B[j]) && ((i == 0) || (A[i] != A[i-1]))){
                result.add(A[i]);
                i++;
                j++;
            }
            else if(A[i] < B[j]){
                i++;
            }
            else{
                j++;
            }
        }
        return result;
    }

    /**
     * EPI: 14.1: This implementation uses O(n) extra space.
     * @param A
     * @param B
     * @return
     */
    public static List<Integer> computeIntersectionWithSet(int[] A, int[] B){
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for(Integer i: A){
            set.add(i);
        }

        for(Integer i: B){
            if(set.contains(i)){
                result.add(i);
                set.remove(i);
            }
        }

        return result;
    }

    /**
     * Plain old binary search
     * @param array
     * @param value
     * @param start
     * @param end
     * @return
     */

    public static int binarySearch(int[] array, int value, int start, int end){
        if(start <= end){
            int mid = (start+end)/2;
            if (array[mid] == value) return mid;
            else if(array[mid] < value) start = mid+1;
            else end = mid-1;
            return binarySearch(array, value, start, end);
        }
        return -1;
    }

    /**
     * Modified binary search to find the closest value to a given value
     * in an array.
     * @param array
     * @param value
     * @return
     */
    public static int findClosest(int[] array, int value){
        if(value < array[0]) return array[0];
        if(value > array[array.length-1]) return array[array.length-1];

        int low = 0;
        int high = array.length -1;

        while(low <= high){
            int mid = (low+high)/2;
            if(array[mid] == value) return array[mid];
            else if(array[mid] < value) low = mid+1;
            else high = mid-1;
        }

        return ((array[low] - value) < (value - array[high])) ? array[low] : array[high];
    }


    public static int findRotationIndex(int[] array){
        if(array.length == 0) return -1;
        int low = 0;
        int high = array.length-1;
        int mid = (low+high)/2;
        while(array[low] > array[high]){
            mid = (low+high)/2;
            if(array[mid] > array[high]) low = mid+1;
            else high = mid;
        }
        return low;
    }
}
