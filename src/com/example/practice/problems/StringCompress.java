package com.example.practice.problems;

/**
 * Given a string compress it using run length encoding.
 * if size of compressed string is larger then original string then return the original string.
 */
public class StringCompress {

    private static String runLengthEncode(String str){
        StringBuilder result = new StringBuilder();
        int count;
        for(int i=0;i<str.length();i++){
            count = 1;
            while((i<str.length()-1) && (str.charAt(i)==str.charAt(i+1))){
                count++;
                i++;
            }
            result.append(str.charAt(i)+""+count);
        }

        return result.length()>=str.length() ? str : result.toString();
    }

    public static void main(String[] args){
        String str = "abcdefghiiiiiiiiiiiiiiiiiiij";
        System.out.println("Orginal string is : "+str);
        System.out.println("Compressed string is : "+runLengthEncode(str));
    }
}
