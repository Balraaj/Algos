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
//        char[] result = ProblemSolver.reverse("Hello this is me".toCharArray());
//        System.out.println(new String(result));
       // lookAndSay();

//        System.out.println(kangaroo(28,8,96,2));
        ip();
    }

    public static void lookAndSay(){
        for(int i=1;i<10;i++){
            System.out.println(ProblemSolver.lookAndSay(i));
        }
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

    static String kangaroo(int x1, int v1, int x2, int v2) {
        if((x1>x2) && (v1>v2)) return "NO";
        if((x2>x1) && (v2>v1)) return "NO";

        double result = ((double)x2-x1)/(v1-v2);
        int intResult = (int)result;
        return ((result<0) || (result!=intResult))? "NO" : "YES";

    }

    private static void ip(){
        System.out.println(ProblemSolver.ipAddress("255255101"));
    }
}
