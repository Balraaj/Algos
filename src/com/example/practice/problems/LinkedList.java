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


    private static LinkedList getSinglyUnsortedListWithDuplicates(){
        Random random = new Random();
        int[] randomNumbers = {123,1,1,1,4,-123,-45,23,1,1,0,56,1,123,0,132,456,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
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

    public static void printLinkedList(LinkedList list){
        Node currentNode = list.head;
        while(currentNode!=null){
            System.out.print(currentNode.getValue()+" ");
            currentNode = currentNode.getNext();
        }
    }

    public static void main(String[] args){
        LinkedList myList = getSinglyUnsortedListWithDuplicates();
        System.out.println("List before duplicate removal");
        printLinkedList(myList);
        removeDuplicatesWithoutBuffer(myList);
        System.out.println("\nList after duplicate removal");
        printLinkedList(myList);
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
