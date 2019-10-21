package com.epi.problems.strings;


import java.util.ArrayList;
import java.util.List;

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

    /**
     * EPI: 7.3: Given a spread sheet column index ex ('AA','ZA','D')
     * convert it to corresponding integer.
     * @param index
     * @return
     */
    public static int decodeSpreadSheetIndex(String index){
        int result = 0;
        for(int i=0; i<index.length(); i++){
            result = (result * 26)+(index.charAt(i) - 'A' +1);
        }
        return result;
    }

    /**
     * EPI: 7.3: Variant: Given an int convert it to spread sheet
     * column index.
     * @param value
     * @return
     */
    public static String encodeIntAsSpreadSheetIndex(int value){
        StringBuilder result = new StringBuilder();
        while(value>=1){
            int digit = value % 26;
            char charToInsert = (char)(digit==0?'Z':'A'+digit-1);
            result.append(charToInsert);
            value = (value - (charToInsert - 'A' +1)) / 26;
        }
        return result.reverse().toString();
    }

    /**
     * EPI: 7.5 : Given a string check if its palindrome.
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str){
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            while((i<j) && (!Character.isLetterOrDigit(str.charAt(i)))) i++;
            while((i<j) && (!Character.isLetterOrDigit(str.charAt(j)))) j--;

            if(Character.toLowerCase(str.charAt(i++)) != Character.toLowerCase(str.charAt(j--))){
                return false;
            }
        }
        return true;
    }

    /**
     * EPI: 7.4: Given a string remove all the b's and replace every
     * a with 2 d's
     * @param str
     * @return
     */
    public static String removeAndReplace(char[] str){
        int currentIndex = 0;
        int copyIndex = 0;
        int totalA = 0;
        while(currentIndex < str.length){
            if(Character.toLowerCase(str[currentIndex])!='b'){
                str[copyIndex++] = str[currentIndex];
            }
            if(Character.toLowerCase(str[currentIndex])=='a') totalA++;
            currentIndex++;
        }

        copyIndex--;
        int startIndex = copyIndex + totalA;
        int count = startIndex;
        while(startIndex >= 0){
            if(Character.toLowerCase(str[copyIndex])=='a'){
                str[startIndex--] = 'd';
                str[startIndex--] = 'd';
            }
            else {
                str[startIndex--] = str[copyIndex];
            }
            copyIndex--;
        }
        return new String(str, 0, count+1);
    }


    /**
     * EPI: 7.6: Given a sentence, reverse all the words
     * in it.
     * EX. "Hello this is me" --> "me is this Hello"
     * @param str
     * @return
     */
    public static char[] reverse(char[] str){
        int i = 0;
        int j = str.length-1;
        while(i<j){
            char temp = str[j];
            str[j--] = str[i];
            str[i++] = temp;
        }

        j = 0;
        int wordStart = 0;
        int wordEnd = 0;
        while(j < str.length){
            /* Skip all the white spaces before a word */
            while((j<str.length) && (Character.isSpaceChar(str[j]))){j++;}
            wordStart = j; // Set word starting location

            /* Move to the end of word*/
            while((j<str.length) && (!Character.isSpaceChar(str[j]))){j++;}
            wordEnd = j-1;

            if((wordStart < wordEnd) && (wordStart < str.length)){
                reverseWord(str,wordStart, wordEnd);
            }
        }

        return str;
    }

    private static void reverseWord(char[] str, int start, int end){
        while(start < end){
            char temp = str[end];
            str[end--] = str[start];
            str[start++] = temp;
        }
    }


    /**
     * EPI: 7.7: Given a phone no. as string,
     * compute all possible mnemonics
     * @param phoneNo
     * @return
     */

    public static List<String> getMnemonics(String phoneNo){
        List<String> mnemonics = new ArrayList<>();
        char[] partialMnemonic = new char[phoneNo.length()];
        mnemonicHelper(phoneNo, 0, partialMnemonic, mnemonics);
        return mnemonics;
    }

    private static String[] MAP = {"0","1","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};
    private static void mnemonicHelper(String phoneNo, int digit, char[] partialMnemonic, List<String> mnemonics){
        if(digit == phoneNo.length()){
            mnemonics.add(new String(partialMnemonic));
        }
        else{
            for(int i=0; i<MAP[phoneNo.charAt(digit) - '0'].length(); i++){
                char c = MAP[phoneNo.charAt(digit) - '0'].charAt(i);
                partialMnemonic[digit] = c;
                mnemonicHelper(phoneNo, digit+1, partialMnemonic, mnemonics);
            }
        }
    }


    /**
     * EPI: 7.8: Look-And-Say problem.
     * return nth term in Look-And-Say sequence;
     * @param n
     * @return
     */
    public static String lookAndSay(int n){
        String start = "1";
        for(int i=1; i<n; i++){
            StringBuilder temp = new StringBuilder();
            int k=0;
            while(k<start.length()){
                char currentChar = start.charAt(k);
                int j = k+1;
                while(j<start.length() && start.charAt(j) == currentChar) j++;
                temp.append(j-k).append(currentChar);
                k=j;
            }
            start = temp.toString();
        }
        return start;
    }

    private static String getNextElement(String str, int start){
        char currentChar = str.charAt(start);
        int i = start+1;
        while(i<str.length() && str.charAt(i) == currentChar) i++;
        return ""+(i-start)+currentChar;
    }

    /**
     * EPI: 7.10: Given an integer which represents a valid ip address.
     * insert the decimal points at correct places
     * @param ipAddress
     * @return
     */

    public static List<String> ipAddress(String ipAddress){
        List<String> result = new ArrayList<>();
        String temp;
        for(int i=0; i<ipAddress.length()-3; i++){
            temp = ipAddress.substring(0,i+1);
            int firstOctet = Integer.valueOf(temp);
            if((temp.length()>1) && (temp.startsWith("0")) || (firstOctet>255)) continue;
            for(int j=i+1; j<i+4 && j<ipAddress.length()-2; j++){
                temp = ipAddress.substring(i+1, j+1);
                int secondOctet = Integer.valueOf(temp);
                if((temp.length()>1) && (temp.startsWith("0")) || (secondOctet>255)) continue;
                for(int k=j+1; k<j+4 && k<ipAddress.length()-1; k++){
                    temp = ipAddress.substring(j+1, k+1);
                    int thirdOctet = Integer.valueOf(temp);
                    if((temp.length()>1) && (temp.startsWith("0")) || (thirdOctet>255)) continue;

                    temp = ipAddress.substring(k+1);
                    int fourthOctet = Integer.valueOf(temp);
                    if((temp.length()>1) && (temp.startsWith("0")) || (fourthOctet>255)) continue;

                    StringBuilder str = new StringBuilder();
                    str.append(firstOctet).append(".")
                            .append(secondOctet).append(".")
                            .append(thirdOctet).append(".")
                            .append(fourthOctet);
                        result.add(str.toString());

                }

            }
        }
        return result;
    }


    /**
     * EPI: 7.11: Given a string return its sinusoid form
     * @param str
     * @return
     */

    public static String sinusoidString(String str){
        StringBuilder result = new StringBuilder();
        for(int i=1; i<str.length(); i+=4){
            result.append(str.charAt(i));
        }

        for(int i=0; i<str.length(); i+=2){
            result.append(str.charAt(i));
        }

        for(int i=3; i<str.length(); i+=4){
            result.append(str.charAt(i));
        }

        return result.toString();
    }
}
