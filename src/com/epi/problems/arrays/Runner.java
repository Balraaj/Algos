package com.epi.problems.arrays;

import com.example.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args){
//        int[] array = {1,2,3,3,2,1,1,2,3,3,2,1,3,3,1,1,2,2};
//        ProblemSolver.dutchFlagSinglePass(array, 2);
//        Util.printArray(array);

        int[] number = {1,6,9,9,9,9};
        List<Integer> integer = new ArrayList<Integer>(){{this.add(9);add(9);add(9);add(9);add(9);add(9);}};
        ProblemSolver.incrementIntegerOptimized(integer);
        System.out.println(integer);
    }
}
