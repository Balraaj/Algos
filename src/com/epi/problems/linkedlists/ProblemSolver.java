package com.epi.problems.linkedlists;

/**
 * A utility class for the solutions of problems
 * which doesn't warrant an individual class
 */
import static com.epi.problems.linkedlists.LinkedList.*;

public class ProblemSolver {

    /**
     * EPI: LinkedList: 8.1: Merge two sorted lists;
     * @param first
     * @param second
     * @return
     */
    public static  LinkedList<Integer> mergeRecursive(LinkedList<Integer> first, LinkedList<Integer> second){
        LinkedList<Integer> parent = first.HEAD.data < second.HEAD.data ? first : second;
        mergeHelper(parent.HEAD.next, second.HEAD, parent.HEAD);
        return parent;
    }

    private static void mergeHelper(ListNode<Integer> first, ListNode<Integer> second,
                                      ListNode<Integer> parent){

        if((first == null) && (second == null)) return;
        if((first != null) && (second != null)) {
            parent.next = first.data < second.data ? first : second;
            parent = parent.next;
            mergeHelper(parent.next, parent == first ? second : first, parent);
        }
        else{
            parent.next = first == null ? second : first;
        }
    }
}
