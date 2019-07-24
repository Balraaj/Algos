package com.example.practice.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {

    public static void main(String[] args){
        BinaryTree<Integer> bt = new BinaryTree<>(12);
//
//

        BinaryTree.buildInteractive(bt);
        List<Integer> levelorder = bt.traverse(BinaryTree.TRAVERSAL_LEVEL_ORDER);
        System.out.print("\nLevelorder traversal is ");
        System.out.print(levelorder);

        List<Integer> inorder = bt.traverse(BinaryTree.TRAVERSAL_IN_ORDER);
        System.out.print("\nInorder traversal is    ");
        System.out.print(inorder);

        List<Integer> preorder = bt.traverse(BinaryTree.TRAVERSAL_PRE_ORDER);
        System.out.print("\nPreorder traversal is   ");
        System.out.print(preorder);

        List<Integer> postorder = bt.traverse(BinaryTree.TRAVERSAL_POST_ORDER);
        System.out.print("\nPostorder traversal is  ");
        System.out.print(postorder);
    }
}
