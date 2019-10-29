package com.epi.problems.linkedlists;

public class Runner {

    public static void main(String[] args){
        LinkedList<Integer> first = LinkedList.getList(new Integer[]{1,2,3,4,5,6,78,80});
//        LinkedList.addCycle(first, 7);
        LinkedList.ListNode<Integer> cycleStart = ProblemSolver.findCycle(first);
        System.out.print(cycleStart == null ? "No cycle" : cycleStart.data);
    }
}
