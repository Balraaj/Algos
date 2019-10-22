package com.epi.problems.linkedlists;


/**
 * A Simple LinkedList implementation, provides a template
 * which can be used to solve EPI linked list problems.
 *
 * @author Balraj
 * @param <T>
 */
public class LinkedList<T> {

    ListNode<T> HEAD = null;

    /**
     * A list node.
     * @param <T>
     */
    public static class ListNode<T>{
        ListNode<T> next;
        T data;

        public ListNode(T data){
            this.next = null;
            this.data = data;
        }
    }

    /**
     * Simple static factory, can be used to create linked list
     * from an array of elements;
     * @param array
     * @param <N>
     * @return
     */
    public static <N> LinkedList<N> getList(N[] array){
        LinkedList<N> list = new LinkedList<>();
        list.HEAD = new ListNode<>(array[0]);
        ListNode<N> currentNode = list.HEAD;
        for(int i=1; i<array.length; i++){
            currentNode.next = new ListNode<>(array[i]);
            currentNode = currentNode.next;
        }
        return list;
    }

    /**
     * Used to print contents of a list;
     * @param list
     * @param <N>
     */
    public static <N> void print(LinkedList<N> list){
        ListNode<N> runner = list.HEAD;
        while(runner != null){
            System.out.print(runner.data + ", ");
            runner = runner.next;
        }
    }

}
