package com.example.practice.ds.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tester {

    public static void main(String[] args){
        BinaryTree<Integer> bt = BinaryTree.buildAlmostCompleteBinaryTree(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10)));
        List<Integer> seq = bt.getLevelOrder();
        for(int i : seq){
            System.out.print(" "+i);
        }
    }
}
