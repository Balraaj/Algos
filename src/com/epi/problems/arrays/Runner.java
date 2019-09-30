package com.epi.problems.arrays;

import com.example.util.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Runner {
    public static void main(String[] args){
        int[] arrayOfShares = {7,11,13,9,12,8,14,13,15};
        System.out.println("Maximum profit is : "+ProblemSolver.buySellShareTwice(arrayOfShares));
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
