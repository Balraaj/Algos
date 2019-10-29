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

    /**
     * EPI: LinkedList: 8.1: An iterative solution.
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode<Integer> mergeIterative(LinkedList<Integer> l1, LinkedList<Integer> l2){
        ListNode<Integer> head = l1.HEAD.data<l2.HEAD.data ? l1.HEAD: l2.HEAD;
        ListNode<Integer> parent  = head;
        ListNode<Integer> runner1 = parent == l1.HEAD ? l2.HEAD : l1.HEAD;
        ListNode<Integer> runner2 = parent.next;

        /**
         * Why runner1 cant be null ?
         * because of the assignment to other runner;
         */
        while(runner1 != null && runner2 != null){
            parent.next = runner1.data < runner2.data ? runner1 : runner2;
            parent = parent.next;
            runner1 = parent == runner1 ? runner2 : runner1;
            runner2 = parent.next;
        }
        parent.next = runner1 == null ? runner2 : runner1;
        return head;
    }

    /**
     * EPI: LinkedList: 8.2: personal variant: Reverse a list
     * @param list
     */
    public static void reverseList(LinkedList<Integer> list){
        reverseHelper(list, list.HEAD, list.HEAD.next);
    }

    private static void reverseHelper(LinkedList<Integer> list, ListNode<Integer> pre, ListNode<Integer> current){
        if(current.next == null){
            list.HEAD.next = null;
            list.HEAD = current;
            current.next = pre;
            return;
        }
        reverseHelper(list, current, current.next);
        current.next = pre;
    }

    /**
     * EPI: 8.3: Given a linked list check if it has a cycle,
     * if cycle exists then return the first node in the cycle.
     * @param list
     * @return
     */
    public static ListNode<Integer> findCycle(LinkedList<Integer> list){
        ListNode<Integer> p1 = list.HEAD;
        ListNode<Integer> p2 = list.HEAD;

        while(p1 != null && p1.next != null && p1.next.next != null){
            p2 = p2.next;
            p1 = p1.next.next;
            if(p1 == p2){
                p1 = list.HEAD;
                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }
}
