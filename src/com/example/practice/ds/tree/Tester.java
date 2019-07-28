package com.example.practice.ds.tree;

import com.example.util.BeanUtils;

import java.util.List;

public class Tester {

    public static void main(String[] args){
//        BinaryTree<Integer> bt = new BinaryTree<>(12);
////
////
//
//        BinaryTree.buildInteractive(bt);
//        List<Integer> levelorder = bt.traverse(BinaryTree.TRAVERSAL_LEVEL_ORDER);
//        System.out.print("\nLevelorder traversal is ");
//        System.out.print(levelorder);
//
//        List<Integer> inorder = bt.traverse(BinaryTree.TRAVERSAL_IN_ORDER);
//        System.out.print("\nInorder traversal is    ");
//        System.out.print(inorder);
//
//        List<Integer> preorder = bt.traverse(BinaryTree.TRAVERSAL_PRE_ORDER);
//        System.out.print("\nPreorder traversal is   ");
//        System.out.print(preorder);
//
//        List<Integer> postorder = bt.traverse(BinaryTree.TRAVERSAL_POST_ORDER);
//        System.out.print("\nPostorder traversal is  ");
//        System.out.print(postorder);

        Class<?> testerClass = Tester.class;
        System.out.println("\nClass loader of Tester is : "+Tester.class.getClassLoader());

        Integer n = 123;
        Class<?> intClass = n.getClass();
        System.out.println("Class loader of Integer is : "+Integer.class.getClassLoader());

        Class<?> listClass = List.class;
        System.out.println("Class loader of List is : "+List.class.getClassLoader());

        A a = new A(123, "Hello");
        B b = BeanUtils.copy(a, B.class);

        System.out.println(b);

        a.b.append(" This is new");
        System.out.println("\nAfter modifying A :"+b.toString());
    }
}

class A{
    private int a;
    public StringBuilder b;

    A(int a, String b){
        this.a = a;
        this.b = new StringBuilder(b);
    }
}


class B{
    private int a;
    private StringBuilder b;

    @Override
    public String toString() {
        return "a is :"+a+" b is : "+b;
    }
}
