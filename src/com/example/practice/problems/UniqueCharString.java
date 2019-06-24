package com.example.practice.problems;

/**
 * Given a string identify if its made up of unique characters.
 */
public class UniqueCharString {

    public static boolean isUnique(String s){
        if(s.length()>26) return false;

        int bitmap = 0;
        for(char c: s.toCharArray()){
            int bitPos = 1<<(c-'a');
            if((bitmap & bitPos)==bitPos) return false;
            bitmap = bitmap ^ bitPos;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("Is unique : "+isUnique("abcdefghijklmnopqrstuvwxyy"));
    }
}
