package com.example.practice.problems;

/**
 * Given a Decimal number convert it to binary representation.
 */
public class Decimal2Binary {

    /**
     * Given a decimal number this method will
     * return the binary representation stored in a long
     * @param decimal the decimal number
     * @return binary representation stored in a long
     */
    public static long toBinary(int decimal){
        long binary = 0;
        int i = 0;
        while(decimal>0){
            int lastDigit = (int)Math.pow(10,i) * (decimal & 1);
            binary = lastDigit + binary;
            decimal = decimal>>1;
            i++;
        }
        return binary;
    }

    /**
     * Given a decimal number this method will return
     * the binary representation stored in a string
     * @param decimal the decimal number
     * @return binary representation stored in a String
     */
    public static String toBinaryString(int decimal){
        if(decimal==0) return "0";
        StringBuilder binary = new StringBuilder();
        while(decimal>0){
            binary.insert(0,decimal & 1);
            decimal = decimal>>1;
        }
        return binary.toString();
    }

    public static void main(String[] args){
        for(int i=0;i<500000;i++){
            System.out.println(i+" ----> "+toBinaryString(i));
        }
    }
}
