package com.example.practice.problems;

/**
 * Given two strings s1 and s2 check if s2 is a rotation of s1.
 * Ex. s1 = Wader
 *     s2 = erWad
 * In this example s2 is a rotation of s1.
 */

public class StringRotation {

    /** Following method is based on the observation that
     *  let s1 = xy and if s2 is some rotation of s1 then we have
     *      s2 = yx
     *
     *  this means s2 must be contained in xyxy.
     */
    public static boolean isRotation(String s1, String s2){
        String temp = s1+s1;
        return (s1.length()==s2.length()) && (temp.contains(s2));
    }

    public static void main(String[] args){
        System.out.println("erWad is a rotation of Wader : "+isRotation("Wader","erWade"));
    }
}
