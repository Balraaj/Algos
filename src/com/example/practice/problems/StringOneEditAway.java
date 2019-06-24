package com.example.practice.problems;

/**
 * Given a two string s1 and s2, determine if they are one edit away
 * that is if we can make both the strings similar by adding, deleting
 * or replacing one character from any string, then they are said to be one edit away.
 */
public class StringOneEditAway {
    public static boolean checkOneEditAway(String s1, String s2){
        return (s1.length()>=s2.length()) ? checkOneReplace(s1,s2) : checkOneReplace(s2,s1);
    }

    private static boolean checkOneReplace(String large, String small){
        if(large.length()-1>small.length()) return false;   // If length differs by more then one then return false
        if(large.equals(small)) return false;   // If string are same then they are not one edit away
        boolean flag = false;

        for(int i = 0,j=0;j<small.length();j++,i++){
            if(large.charAt(i)!=small.charAt(j)){
                if(flag) return false;
                flag = true;
                if(large.length()>small.length()){
                    j--;        // To handle insert or delete case
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("one edit away : "+checkOneEditAway("aaab","aaa"));
    }
}
