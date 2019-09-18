package com.epi.problems.arrays;

import com.example.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args){
        int[] array = {3,2,0,0,2,0,1};
        System.out.println("Game is winnable : "+ProblemSolver.solveBoardGame(array));
    }
}
