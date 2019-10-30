package com.epi.problems.random;

public class Runner {

    public static void main(String[] args){
        int[] first = {1,1,1,2,3,6,9,15};
        int[] second = {1,6,8,9,12,14,15,56};
        System.out.print(ProblemSolver.computeIntersection(first, second));
        System.out.print(ProblemSolver.computeIntersectionWithSet(first, second));
    }
}
