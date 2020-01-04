package com.example.kotlin;

import java.util.List;

public class JavaTemp {
   public static void remove(List<Integer> list){
       for(int i=0; i<list.size(); i++){
           list.set(i, list.get(i)*2);
       }
   }
}
