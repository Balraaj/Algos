package com.example.practice.problems;

/**
 * Given a string determine if it's a permutation of some palindrome.
 * that is using characters of string can a palindrome be formed.
 * assume that str contains all lower letters
 */
public class PalindromePermutation {
    private static boolean canFormPalindrome(String str){

        // use bitmap to reduce the space usage.
        int bitmap = 0;
        for(char c: str.toCharArray()){
            bitmap = (bitmap ^ (1<<(c-'a')));
        }
        return (bitmap==0) || ((bitmap&bitmap-1)==0);
    }

    public static void main(String[] args){
        System.out.println("Can form palindrom : "+ canFormPalindrome("thissihtwhattahwgk"));
    }
}
