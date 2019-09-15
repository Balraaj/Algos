package com.epi.problems.arrays;

import com.example.util.Util;

public class Runner {
    public static void main(String[] args){
        int[] array = {1,2,3,3,2,1,1,2,3,3,2,1,3,3,1,1,2,2};
        ProblemSolver.dutchFlagSinglePass(array, 2);
        Util.printArray(array);
    }
}
