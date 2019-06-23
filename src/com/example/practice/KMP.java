package com.example.practice;

class KMP {

    private static int[] computerPrefix(String pattern){

        int[] prefix = new int[pattern.length()];
        prefix[0] = 0;
        int k = 0;
        for(int i=1; i<pattern.length(); i++){
            while((k>0) && (pattern.charAt(k)!=pattern.charAt(i))){
                k = prefix[k-1];
            }
            if(pattern.charAt(i)==pattern.charAt(k)){
                k++;
            }
            prefix[i] = k;
        }
        return prefix;
    }

    static void match(String pattern, String text){
        int[] prefix = computerPrefix(pattern);
        int k = 0;
        for(int i=0;i<text.length();i++){
            while((k>0) && (text.charAt(i)!=pattern.charAt(k))){
                k = prefix[k-1];
            }
            if(text.charAt(i)==pattern.charAt(k)){
                k++;
            }
            if(k==pattern.length()){
                System.out.println("Match found at : "+(i-k+1)+","+i);
                k = prefix[k-1];
            }
        }
    }
}
