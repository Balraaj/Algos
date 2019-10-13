package com.epi.problems.strings;

/**
 * A utility class for the solutions of problems
 * which doesn't warrant an individual class
 */

public class ProblemSolver {

    /**
     * EPI: 7.1: Given an integer stored as a string.
     * convert it to the corresponding int value;
     * @param str
     * @return
     */
    public static int s2I(String str){
        if((str.length()==0) ||
          ((str.length()==1) && ((str.charAt(0)=='-') || (str.charAt(0)=='+')))){
            throw new NumberFormatException();
        }

        boolean isSigned = str.charAt(0) == '-' || str.charAt(0) == '+';
        int number = 0;
        for(int i = isSigned ? 1 : 0; i<str.length(); i++){
            char currentChar = str.charAt(i);
            if(currentChar<'0' || currentChar>'9'){
                throw new NumberFormatException();
            }
            else{
                number = (number*10) + (currentChar - '0');
            }
        }
        return str.charAt(0) == '-' ? -number : number;
    }

    /**
     * EPI: 7.1: Given an integer.
     * convert it to the corresponding string;
     * @param number
     * @return
     */
    public static String i2S(int number){
        StringBuilder str = new StringBuilder();
        if(number==0) return "0";
        boolean isNegative = false;
        if(number<0){
            isNegative = true;
            number = -number;
        }
        while(number!=0){
            int digit = number%10;
            str.append((char)(digit+'0'));
            number/=10;
        }

        if(isNegative) return str.append('-').reverse().toString();
        return str.reverse().toString();
    }

    /**
     * EPI: 7.2: Given a number as a string in base b1,
     * convert this number to base b2.
     * EX: number ABCDEF, b1 = 16, b2 = 10 --> result = 10340300000
     *
     * Many optimizations can be made, for example if b1 is square root of b2
     * or b2 is square root of b1.
     * Base conversion
     */

    public static String convertBase(String number, int b1, int b2){
        boolean isNegative = number.charAt(0) == '-';
        boolean isSigned = isNegative || number.charAt(0) == '+';
        StringBuilder result = new StringBuilder();

        int decimal = 0;
        for(int i = isSigned ? 1 : 0; i<number.length(); i++){
            char c = number.charAt(i);
            int digit = Character.isDigit(c) ? (c-'0') : ((c-'A') + 10);
            decimal = (decimal * b1) + digit;
        }

        while(decimal>0){
            int digit = decimal % b2;
            if(digit>=10){
                result.append((char)(55+digit));
            }
            else{
                result.append(digit);
            }
            decimal/=b2;
        }
        return isNegative ? result.append('-').reverse().toString() : result.reverse().toString();
    }
}
