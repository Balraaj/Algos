package com.example.practice.problems;

import java.util.HashMap;
import java.util.Random;

public class LinkedList {

    private Node head;

    /**
     * Given a singly linked list, this method removes all the duplicate values from the list.
     * it takes O(n) time to execute and requires O(n) extra space.
     */
    private static void removeDuplicates(LinkedList list){
        HashMap<Integer,Integer> map = new HashMap<>();
        Node previousNode = list.head;
        Node currentNode = list.head;
        while(currentNode!=null){
            if(map.containsKey(currentNode.getValue())){
                previousNode.setNext(currentNode.getNext());
                currentNode.setNext(null);
                currentNode = previousNode.getNext();
            }
            else{
                map.put(currentNode.getValue(),1);
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
        }
    }

    /** Given a singly linked list, this method removes all the duplicate values from the list.
     * it takes O(n^2) time and requires no extra space.
     */
    private static void removeDuplicatesWithoutBuffer(LinkedList list){
        Node runner = list.head;
        Node previousNode = null;
        Node currentNode = null;
        while(runner!=null){
            int runnerValue = runner.getValue();
            currentNode = runner.getNext();
            previousNode = runner;

            while(currentNode!=null){
                if(currentNode.getValue()==runnerValue){
                    previousNode.setNext(currentNode.getNext());
                    currentNode.setNext(null);
                    currentNode = previousNode.getNext();
                }
                else{
                    previousNode = currentNode;
                    currentNode = currentNode.getNext();
                }
            }
            runner = runner.getNext();
        }
    }

    /** Given a linked list and an integer k,
     *  this method returns kth to last element.
     */
    private static Node getKthToLast(LinkedList list, int k){
        Node start = list.head;
        Node kth = list.head;
        int difference = 0;
        while(difference<k) {
            difference++;
            start = start.getNext();
        }
        while(start.getNext()!=null){
            kth = kth.getNext();
            start = start.getNext();
        }
        return kth;
    }

    /**
     * Given a singly linked list this method removes the middle node.
     * middle node is only defined if the list contains more then 2 elements.
     * Note : This method doesn't remove the exact middle node,
     * in fact it copies the data from next node into current node and then removes the next node.
     */
    private static void removeMid(LinkedList list){
        Node middle = getMiddle(list);
        middle.setValue(middle.getNext().getValue());
        middle.setNext(middle.getNext().getNext());
    }

    /**
     * Unlike the above method this method removes the exact middle node.
     * That is middle value as well as the Node in which it was stored.
     * @param list
     */
    private static void removeExactMid(LinkedList list){
        Node runner, mid, prevMid;
        runner = mid = prevMid = list.head;
        while((runner!=null) && (runner.getNext()!=null)){
            runner = runner.getNext().getNext();
            prevMid = mid;
            mid = mid.getNext();
        }
        prevMid.setNext(mid.getNext());
        mid.setNext(null);
    }

    /** This method partitions the linked list around the pivot value.
     *
     */
    private static void partitionQuickSortStyle(LinkedList list, int pivot){
        Node runner = list.head;
        Node maxNode = list.head;
        while(runner!=null) {
            if (runner.getValue() < pivot) {
                int temp = runner.getValue();
                runner.setValue(maxNode.getValue());
                maxNode.setValue(temp);
                maxNode = maxNode.getNext();
            }
            runner = runner.getNext();
        }
    }

    private static Node getNodeWithValue(LinkedList list, int value){
        Node runner = list.head;
        while(runner!=null){
            if(runner.getValue()==value) return runner;
            runner = runner.getNext();
        }
        return null;
    }

    private static boolean isPalindrome(LinkedList list){
        Node secondPart = getMiddle(list).getNext();
        Node firstPart = list.head;

        while(secondPart!=null){
            if(firstPart.getValue()!=secondPart.getValue()) return false;

            firstPart = firstPart.getNext();
            secondPart = secondPart.getNext();
        }
        return true;
    }

    private static Node getMiddle(LinkedList list){
        int count = 1;
        Node middleNode = list.head;
        Node currentNode = list.head;
        while(currentNode!=null){
            count++;
            if(count%2==1){
                middleNode = middleNode.getNext();
            }
            currentNode = currentNode.getNext();
        }
        return middleNode;
    }

    private static void getReversedList(LinkedList list){
         reverse(list, list.head, list.head.getNext(),list.head);

    }

    private static void reverse(LinkedList list, Node previous, Node current, Node oldHead){
        if(current.getNext()==null){
            list.head = current;
            current.setNext(previous);
            return;
        }
        reverse(list,current,current.getNext(),oldHead);
        current.setNext(previous);
        if(previous==oldHead){
            previous.setNext(null);
        }
        return;
    }

    private static LinkedList getPalindromeList(){
        Random random = new Random();
        int[] randomNumbers = {123,1,3,4,8,4,3,1,123};
        LinkedList list = new LinkedList();
        list.head = new Node(randomNumbers[0]);
        Node currentNode = list.head;
        for(int i=1;i<randomNumbers.length;i++){
            currentNode.setNext(new Node(randomNumbers[i]));
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(null);
        return list;
    }

    private static LinkedList getSinglyUnsortedListWithDuplicates(int... args){
        Random random = new Random();
        int[] randomNumbers = (args.length==0)?new int[]{123,1,1,1,4,-123,-45,23,1,1,0,56,1,123,0,132,456,1}:args;
        LinkedList list = new LinkedList();
        list.head = new Node(randomNumbers[0]);
        Node currentNode = list.head;
        for(int i=1;i<randomNumbers.length;i++){
            currentNode.setNext(new Node(randomNumbers[i]));
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(null);
        return list;
    }

    private static Node getNode(LinkedList list, Node node){
        Node runner = list.head;
        while(runner!=null){
            if(runner == node ) return runner;
            runner = runner.getNext();
        }
        return null;
    }

    public static void printLinkedList(LinkedList list){
        Node currentNode = list.head;
        while(currentNode!=null){
            System.out.print(currentNode.getValue()+" ");
            currentNode = currentNode.getNext();
        }
    }

    /*
     Given two linked lists where each list stores a number.
     this method return a new linked list which stores sum of both the lists.
     */
    private static LinkedList add(LinkedList l1, LinkedList l2){
        int firstNumber = 0;
        int secondNumber = 0;
        Node runner1 = l1.head;
        Node runner2 = l2.head;
        while((runner1!=null)||(runner2!=null)){
            if(runner1!=null){
                firstNumber = firstNumber*10+runner1.getValue();
                runner1 = runner1.getNext();
            }
            if(runner2!=null){
                secondNumber = secondNumber*10+runner2.getValue();
                runner2 = runner2.getNext();
            }
        }

        int newNumber = firstNumber+secondNumber;
        LinkedList newList = new LinkedList();
        newList.head = addHelper(null,newNumber);
        return newList;
    }


    private static Node addHelper(Node node, int value){
        if(value == 0) return node;

        Node newNode = new Node(value%10);
        newNode.setNext(node);
        return addHelper(newNode,value/10);
    }
    public static void main(String[] args){

        /* Testing for kth to last element method */
//        LinkedList myList = getPalindromeList();
//        for(int i=0; i<5;i++){
//            System.out.println(i+"th from last is : "+getKthToLast(myList,i).getValue());
//        }
//
        /* Testing for middle element removal */
//        LinkedList myList = getSinglyUnsortedListWithDuplicates(1,2,3,4,5,6);
//        System.out.print("List before removal : ");
//        printLinkedList(myList);
//        Node midNode = getMiddle(myList);
//        removeMid(myList);
//        midNode = getNode(myList,midNode);
//        System.out.print("mid exists : "+((midNode==null)? "No":midNode.getValue()));
//        System.out.print("\nList after removal : ");
//        printLinkedList(myList);

        // Test for partition method
//        LinkedList myList = getSinglyUnsortedListWithDuplicates(13,123,34,5,12,3,123,123,56,4,123,90,56,34,56,12,6,5,34,23);
//        partitionQuickSortStyle(myList,57);
//        printLinkedList(myList);

        LinkedList newList = add(getSinglyUnsortedListWithDuplicates(1,2,3,4),getSinglyUnsortedListWithDuplicates(0,0));
        printLinkedList(newList);
    }
}

class Node{
    private Node next;
    private int value;

    public Node(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
