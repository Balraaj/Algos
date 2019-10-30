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
}
