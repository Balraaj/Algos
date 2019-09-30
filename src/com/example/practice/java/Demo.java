package com.example.practice.java;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo{
    public static void main(String[] args){
        long time = System.currentTimeMillis();
        A object = new A();

        object.test();
//        if(time%2==0){
//            object = new A();
//        }
//        else{
//            object = new B();
//        }
//        object.staticA();
//        object.A();
    }
}

class A {

    public void test(){
        final AtomicInteger i = new AtomicInteger(1);
        class Temp{
            public void run()  {
                try{
                    i.incrementAndGet();
                    Thread.sleep(5000);
                    System.out.println("Run is finishing");
                }
               catch (Exception E){

               }
            }
        }
        Temp t = new Temp();
        Thread newThread = new Thread(t::run);
        newThread.start();
        System.out.println("Test is finishing");
    }

    public static void staticA(){
        System.out.println("This is staticA in A");
    }

    public void A(){
        System.out.println("This is A");
    }
}

class B extends A{

    public static void staticA(){
        System.out.println("This is staticA in B");
    }

    public void A(){
        System.out.println("This is B");
    }

    public void A(int a){
        System.out.println("This is overloaded a");
    }
}
