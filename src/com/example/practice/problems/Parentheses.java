package com.example.practice.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * This program find any mismatched brackets.
 */
public class Parentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\balra\\CS_Practice\\src\\myfile.txt"));
        checkParentheses(br);
    }

    private static void checkParentheses(BufferedReader br) throws IOException {
        int lineNo = 0;
        boolean flag = true;
        String str;
        Stack<Map<Character,Integer>> stack = new Stack<>();
        while((str=br.readLine())!=null){
            lineNo++;
            final int lineNoFinal = lineNo;
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if((c=='(')||(c=='{')||(c=='[')) stack.push(new HashMap<Character, Integer>(){{put(c,lineNoFinal);}});
                if((c==')')||(c=='}')||(c==']')){
                    if(stack.isEmpty()){
                        flag = false;
                        System.out.print("\nProblem at line: "+lineNo+", No matching brace found for "+c);
                        continue;
                    }
                    Map<Character,Integer> map = stack.peek();
                    char top = (Character)(map.keySet().toArray()[0]);
                    if(((top=='(')&&(c==')')) || ((top=='{')&&(c=='}')) || (top=='[')&&(c==']')){
                        stack.pop();
                    }
                    else{
                        flag = false;
                        System.out.print("\nProblem at line: "+lineNo+", "+c+" doesn't match "+top);
                        stack.pop();
                        i--;
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            flag = false;
            Map<Character,Integer> map = stack.pop();
            char top = (Character)(map.keySet().toArray()[0]);
            int topCharLine = map.get(top);
            System.out.print("\n No matching brace found for "+top+" at line : "+topCharLine);
        }
        if(flag) System.out.println("No problem found");
    }
}
