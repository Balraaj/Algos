package com.epi.problems.linkedlists;

public class Runner {

    public static void main(String[] args){
        LinkedList<Integer> first = LinkedList.getList(new Integer[]{1,2,3,4,5,6,78,80});
        LinkedList<Integer> second = LinkedList.getList(new Integer[]{2,4,6,8,8,8,8,8,8,12,14,16,17});
        LinkedList.ListNode<Integer> result = ProblemSolver.mergeIterative(first, second);
        while(result !=null){
            System.out.print(result.data+", ");
            result = result.next;
        }
    }
}
