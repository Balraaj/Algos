package com.epi.problems.arrays;

import com.example.util.Util;

public class Runner {
    public static void main(String[] args){
        int[] array = {67,12,34,14,89,2,25,87,-12,45,0,25};
        ProblemSolver.dutchFlag(array, array.length-1);
        Util.printArray(array);
    }
}
