package com.epi.problems.arrays;

import com.example.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Runner {
    public static void main(String[] args){
//        int[] arrayOfShares = {7,11,13,9,12,8,14,13,15};
//        System.out.println("Maximum profit is : "+ProblemSolver.buySellShareTwice(arrayOfShares));

        /* Print list of all primes in first 1000 numbers; */
//        System.out.println(ProblemSolver.findPrimesUptoN(10));
//
//        String pattern = "abcdef";
//        int[] permutation = {5,4,3,2,1,0};
//        System.out.println(ProblemSolver.permute(pattern, permutation));
////
//        int[] array = {1,2,3,4,5,6,7,8,9};
//        for(int i=1; i<10; i++){
//            System.out.println();
//            Util.printArray(ProblemSolver.offlineData(array, 5), 5);
//        }

        computeRandomPermutations();
    }

    private static void computeRandomPermutations(){
        for(int i=0; i<10; i++){
            System.out.println();
            Util.printArray(ProblemSolver.randomPermutation(10));
        }
    }

    private static void getNextPermutation(){

        int[] permutation = {0,9,8,7,6,5,4,3,2,1};
        System.out.println("\nCurrent permutation is : ");
        Util.printArray(permutation);
        permutation = ProblemSolver.nextPermutation(permutation);
        System.out.println("\nNext permutation is : ");
        Util.printArray(permutation);
    }

    private static void rotateArray(){
        int[] array = {1,2,3,4,5,6,7,8,9,10};
            array = ProblemSolver.rotateArray(new int[]{1,2,3,4,5,6,7,8},3);
            Util.printArray(array);
            System.out.println("\n\n");

        array = ProblemSolver.rotateArray(new int[]{1,2,3,4,5,6,7,8},-5);
        Util.printArray(array);
        System.out.println("\n\n");

    }
}

class HashSet<T>{
    private Object value = new Object();
    private HashMap<T, Object> map = new HashMap<>();
    public void add(T t){
        map.put(t,value);
    }
}
