package com.example.practice.problems;

/**
 * Given a string of words,
 * if a word's length is greater then 4 and even then print a space in middle of word
 * otherwise print word as it is.
 */
public class SpaceWord {

    public static void print(String str){

        int index = 0;
        while(index<str.length()){
            int wordStartIndex = getNextNonSpaceIndex(str,index);
            if(wordStartIndex==-1) break;
            int wordEndIndex = getNextSpaceIndex(str, wordStartIndex);
            printWord(str,wordStartIndex, wordEndIndex);
            index = wordEndIndex;
        }

    }

    private static void printWord(String str, int start, int end){
        int wordLength = end-start;
        String word = str.substring(start,end);
        if((wordLength>4) && (wordLength%2==0)){
            word = str.substring(start,start+(wordLength/2)) + " " + str.substring(start+(wordLength/2), end);
        }
        System.out.println(word);
    }

    private static int getNextSpaceIndex(String str, int currentIndex){
        while((currentIndex<str.length()) && (!Character.isSpaceChar(str.charAt(currentIndex)))){
            currentIndex++;
        }
        return currentIndex;
    }

    private static int getNextNonSpaceIndex(String str, int currentIndex){
        while((currentIndex<str.length()) && (Character.isSpaceChar(str.charAt(currentIndex)))){
            currentIndex++;
        }
        return (currentIndex==str.length()) ? -1 : currentIndex;
    }

    public static void main(String... args){
        String str = "a b c d e f ghi      Balraj";
        print(str);
    }
}
