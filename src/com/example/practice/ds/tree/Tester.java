package com.example.practice.ds.tree;

import java.util.List;

public class Tester {

    public static void main(String[] args){
        BinaryTree<Integer> bt = new BinaryTree<>(123);
        List<Integer> inorder = bt.traverseInorder();
        System.out.print(inorder);
    }
}
