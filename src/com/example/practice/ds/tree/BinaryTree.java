package com.example.practice.ds.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * A binary tree implementation in java
 * @param <T> type of element that would be stored in the binary tree node.
 */

public class BinaryTree<T> {

    private Node<T> root;

    /* constants defining the different traversal types */
    public static final int TRAVERSAL_IN_ORDER    = 1;
    public static final int TRAVERSAL_PRE_ORDER   = 2;
    public static final int TRAVERSAL_POST_ORDER  = 3;
    public static final int TRAVERSAL_LEVEL_ORDER = 4;

    BinaryTree(T value){
        this.root = new Node(value, null,null,null);
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

    public List<T> traverse(int traversalType){
        List<T> sequence = new ArrayList<>();
        switch (traversalType){
            case TRAVERSAL_IN_ORDER:
                traverseInorder(sequence, this.root);
                break;
            case TRAVERSAL_PRE_ORDER:
                traversePreorder(sequence, this.root);
                break;
            case TRAVERSAL_POST_ORDER:
                traversePostorder(sequence, this.root);
                break;
            case TRAVERSAL_LEVEL_ORDER:
                List<Node<T>> nodes = new ArrayList<>();
                nodes.add(this.root);
                traverseLevelorder(sequence,nodes);
                break;
            default: return defaultTraversal();
        }
        return sequence;
    }

    private List<T> defaultTraversal(){
        List<T> sequence = new ArrayList<>();
        traverseInorder(sequence, this.root);
        return sequence;
    }

    private void traverseInorder(List<T> sequence, Node<T> node){
        if(node!=null){
            traverseInorder(sequence, node.leftChild);
            sequence.add(node.element);
            traverseInorder(sequence, node.rightChild);
        }
    }

    private void traversePreorder(List<T> sequence, Node<T> node){
        if(node!=null){
            sequence.add(node.element);
            traversePreorder(sequence, node.leftChild);
            traversePreorder(sequence, node.rightChild);
        }
    }

    private void traversePostorder(List<T> sequence, Node<T> node){
        if(node!=null){
            traversePostorder(sequence, node.leftChild);
            traversePostorder(sequence, node.rightChild);
            sequence.add(node.element);
        }
    }

    private void traverseLevelorder(List<T> sequence, List<Node<T>> nodes){
        if(nodes.size()==0) return;
        Node<T> currentNode = nodes.remove(0);
        if((currentNode!=null)){
            sequence.add(currentNode.element);
            nodes.add(currentNode.leftChild);
            nodes.add(currentNode.rightChild);
        }
        traverseLevelorder(sequence,nodes);
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
    }

}
