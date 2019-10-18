package com.epi.problems.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Runner {

    public static void main(String[] args){
//        String number = ProblemSolver.i2S(-123234);
//        System.out.println(number);
//        System.out.println(ProblemSolver.convertBase("ABCDEF",16,5));

//          System.out.println(ProblemSolver.removeAndReplace("babcbdbebbbbbbfbagbhbbibbb".toCharArray()));
        char[] result = ProblemSolver.reverse("b       a c what    ".toCharArray());
        System.out.println(new String(result));
    }

    public static void decode(){
     for(int k=0;k<50;k++){
         for(int i=1;i<=6;i++){
             StringBuilder s1 = new StringBuilder();
             for(int j=0; j<i; j++){
                 int digit = ThreadLocalRandom.current().nextInt(0, 26);
                 s1.append((char)('A' + digit));
             }
             String s2 = ProblemSolver.encodeIntAsSpreadSheetIndex(ProblemSolver.decodeSpreadSheetIndex(s1.toString()));
             assert (s2.equals(s1.toString()));
             System.out.println("Input : "+s1.toString()+", Output : "+s2);
         }
     }

     for (int i=1; i<2000;i++){
         System.out.println(ProblemSolver.encodeIntAsSpreadSheetIndex(i));
     }
    }
}
