package com.epi.problems.linkedlists;

public class Runner {

    public static void main(String[] args){
        LinkedList<Integer> first = LinkedList.getList(new Integer[]{1});
        LinkedList<Integer> second = LinkedList.getList(new Integer[]{2,4,6,8,8,8,8,8,8,12,14,16,17});
        LinkedList<Integer> result = ProblemSolver.merge(first, second);
        LinkedList.print(result);
    }
}
