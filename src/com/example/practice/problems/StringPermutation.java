package com.example.practice.problems;

/**
 * Given two strings s1 and s2.
 * check if s1 is a permutation of s2.
 * we assume that both strings only contain english text and all letters are in lower case.
 */
public class StringPermutation {
    public static boolean isPermutation(String s1, String s2){
        int[] array = new int[26];
        int count = 0;

        /**
         * Store no of occurrences of every char in the array
         */
        for(char c : s1.toCharArray()){
            array[c-97]++;
        }

        for(char c: s2.toCharArray()){
            if(array[c-97]==0) break;
            array[c-97]--;
            count++;
        }

        if(count==s1.length()) return true;
        return false;
    }

    public static void main(String[] args){
        System.out.println(isPermutation("balraj","aabjlr"));
    }
}
