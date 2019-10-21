package com.epi.problems.strings;

public class KMP {

    /**
     * EPI: 7.13: Given two strings, text and pattern.
     * find first occurrence of pattern in text
     * @param text
     * @param pattern
     * @return
     */
    public static int firstOccurrence(String text, String pattern){
        int[] prefix = prefix(pattern);
        int k = 0;
        for(int i=0; i<text.length(); i++){
            while((k>0) && (text.charAt(i) != pattern.charAt(k))){
                k = prefix[k-1];
            }
            if(text.charAt(i) == pattern.charAt(k)){
                k++;
            }
            if(k == pattern.length()){
                return (i-k+1);
            }
        }
        return -1;
    }


    private static int[] prefix(String pattern){
        int[] prefix = new int[pattern.length()];
        prefix[0] = 0;
        int k = 0;
        for(int i=1; i<pattern.length(); i++){
            while((k>0) && (pattern.charAt(k) != pattern.charAt(i))){
                k = prefix[k-1];
            }
            if(pattern.charAt(k) == pattern.charAt(i)){
                k++;
            }
            prefix[i] = k;
        }
        return prefix;
    }


}
