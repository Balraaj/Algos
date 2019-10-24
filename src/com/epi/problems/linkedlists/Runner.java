package com.epi.problems.linkedlists;

public class Runner {

    public static void main(String[] args){
        LinkedList<Integer> first = LinkedList.getList(new Integer[]{1,2,3,4,5,6,78,80});
        System.out.print("\n------------ First Reversal ------------\n");
        ProblemSolver.reverseList(first);
        LinkedList.print(first);
        System.out.print("\n------------ Second Reversal -----------\n");
        ProblemSolver.reverseList(first);
        LinkedList.print(first);
    }
}
