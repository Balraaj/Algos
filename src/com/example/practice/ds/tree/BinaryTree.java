package com.example.practice.ds.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
     * Factory method to build an almost complete binary tree from the given input.
     * @param elements list of elements to be inserted in level order in the tree
     * @param <E> type of elements
     * @return a binary tree with all levels except possibly the last one full
     */
    public static <E> BinaryTree<E> buildAlmostCompleteBinaryTree(List<E> elements){
        BinaryTree<E> bt = new BinaryTree<>(elements.get(0));
        bt.root = addChildren(bt.root, elements, 0);
        return bt;
    }

    /**
     * Helper method for buildAlmostCompleteBinaryTree
     * @param root
     * @param elements
     * @param currentIndex
     * @param <E>
     * @return
     */
    private static <E> Node<E> addChildren(Node<E> root, List<E> elements, int currentIndex){
        if(currentIndex<elements.size()){
            root = new Node<>(elements.get(currentIndex),null,null,null);
            root.leftChild = addChildren(root.leftChild, elements,currentIndex*2+1);
            root.rightChild = addChildren(root.rightChild, elements, currentIndex*2+2);
        }
        return root;
    }


    /**
     * This method returns a sequence of all the elements of tree in level order.
     * @return
     */
    public List<T> getLevelOrder(){
        List<T> sequence = new ArrayList<>();
        List<Node<T>> nodes = new ArrayList<>();
        nodes.add(this.root);
        return helper(nodes, sequence);
    }

    private List<T> helper(List<Node<T>> nodes, List<T> sequence){
        if(nodes.size()==0) return sequence;
        Node<T> currentNode = nodes.remove(0);
        if((currentNode!=null)){
            sequence.add(currentNode.element);
            nodes.add(currentNode.leftChild);
            nodes.add(currentNode.rightChild);
            helper(nodes,sequence);
        }
        return sequence;
    }

    /**
     * This class represents a node in the binary tree
     * @param <T> type of element that would be stored in this node.
     *            all the nodes of a particular binary tree have same type.
     */
    private static class Node<T>{
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
