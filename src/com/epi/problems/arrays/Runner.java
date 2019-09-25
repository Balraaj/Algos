package com.epi.problems.arrays;

import com.example.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Runner {
    public static void main(String[] args){

        ProblemSolver.maxSumSubArray(new int[]{-5,4,12,-16,35,-9});
//        int[] array = {3,2,0,0,2,0,1};
//        System.out.println("Game is winnable : "+ProblemSolver.solveBoardGame(array));
    }

    public abstract void get();
}

class HashSet<T>{
    private Object value = new Object();
    private HashMap<T, Object> map = new HashMap<>();
    public void add(T t){
        map.put(t,value);
    }
}
