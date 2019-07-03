package com.example.practice.problems;


/**
 * Given a string perform some of all the digits that it contains.
 */
public class StringDigitsSum {

    public static int performSum(String str){
       int i = 0;
       int sum = 0;
       while(i<str.length()){
           while((i<str.length()) && (!Character.isDigit(str.charAt(i)))) i++;
           if(i<str.length()) sum = sum + Integer.parseInt(str.charAt(i++)+"");
       }
       return sum;
    }

    public static void main(String[] args){
        String str = "a1a1a1a1a1a1a1a1";
        System.out.print("Sum of "+str+" is : "+performSum(str));
    }
}
