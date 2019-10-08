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

        getNextPermutation();
    }

    public abstract void get();

    private static void getNextPermutation(){

        int[] permutation = {0,9,8,7,6,5,4,3,2,1};
        System.out.println("\nCurrent permutation is : ");
        Util.printArray(permutation);
        permutation = ProblemSolver.nextPermutation(permutation);
        System.out.println("\nNext permutation is : ");
        Util.printArray(permutation);
    }
}

class HashSet<T>{
    private Object value = new Object();
    private HashMap<T, Object> map = new HashMap<>();
    public void add(T t){
        map.put(t,value);
    }
}
