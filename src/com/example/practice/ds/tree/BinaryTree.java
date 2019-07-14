package com.example.practice.ds.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * A binary tree implementation in java
 * @param <T> type of element that would be stored in the binary tree node.
 */

public class BinaryTree<T> {

    private Node<T> root;

    BinaryTree(T value){
        this.root = new Node(value, null,null,null);
    }

    public List<T> traverseInorder(){
        List<T> sequence = new ArrayList<>();
        inorder(sequence, this.root);
        return sequence;
    }

    private void inorder(List<T> sequence, Node<T> node){
        if(node==null) return;
        sequence.add(node.element);
        inorder(sequence, node.leftChild);
        inorder(sequence, node.rightChild);
    }


    /**
     * This class represents a node in the binary tree
     * @param <T> type of element that would be stored in this node.
     *            all the nodes of a particular binary tree have same type.
     */
    private class Node<T>{
        private T element;
        private Node<T> parent;
        private Node<T> leftChild;
        private Node<T> rightChild;

        Node(T element, Node<T> parent, Node<T> leftChild, Node<T> rightChild){
            this.element = element;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        Node(){}
    }

}
