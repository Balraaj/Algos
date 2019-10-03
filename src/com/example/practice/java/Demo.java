package com.example.practice.java;

import java.util.Scanner;
import java.util.TreeMap;
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

    public static int problemSolver(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++){
            int scannerNo = s.nextInt();
            if(map.containsKey(scannerNo)){
                map.put(scannerNo, map.get(scannerNo)+1);
            }
            else{
                map.put(scannerNo,1);
            }
        }

        if(map.size()==1){
            return map.firstEntry().getValue();
        }

        Integer key = map.higherKey(map.firstKey());
        while(key != null){
            int bullets = map.get(key);
            while(bullets > 0){
                Integer smallerKey = map.lowerKey(key);
                if(smallerKey != null){
                    if(map.get(smallerKey) == 1) map.remove(smallerKey);
                    else map.put(smallerKey, map.get(smallerKey)-1);
                }
                else{
                    break;
                }
                bullets--;
            }
            key = map.higherKey(key);
        }

        int totalSkill = 0;
        for(int k : map.keySet()){
            totalSkill = totalSkill + k*map.get(k);
        }
        return totalSkill;
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
