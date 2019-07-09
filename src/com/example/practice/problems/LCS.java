package com.example.practice.problems;

/**
 * Given two strings A and B find the longest common sub sequence.
 */
public class LCS {

    private static int[][] C;
    private static int[][] D;
    private static String A;
    private static String B;

    public static void getLcs(String A, String B){
        A = " "+A;
        B = " "+B;
        LCS.A = A;
        LCS.B = B;
        C = new int[A.length()+1][B.length()+1];
        D = new int[A.length()][B.length()];
        for(int i=0;i<A.length();i++) C[i][0] = 0;
        for(int i=0;i<B.length();i++) C[0][i] = 0;

        char charA;
        char charB;

        for(int i=1;i<A.length();i++){
            for(int j=1;j<B.length();j++){
                charA = A.charAt(i);
                charB = B.charAt(j);

                if(charA==charB){
                    C[i][j] = C[i-1][j-1]+1;
                }
                else if(C[i-1][j]>C[i][j-1]){
                    C[i][j] = C[i-1][j];
                }
                else{
                    C[i][j] = C[i][j-1];
                }
            }
        }
    }

    public static int getLcsLength(){
        return C[C.length-1][C[0].length-1];
    }

    public static void printLCS(int x, int y){
        if(x==0 || y==0){
            return;
        }
        if(A.charAt(x)==B.charAt(y)){
            printLCS(x-1,y-1);
            System.out.print(" "+A.charAt(x));
        }
        else if(C[x-1][y]>C[x][y-1]){
            printLCS(x-1,y);
        }
        else{
            printLCS(x,y-1);
        }
    }

    public static void main(String[] args){
        String A = "AABCDEFGHIsssssssssssssssssssssf";
        String B = "ABETTGHIgggggggggggggggggggf";

        getLcs(A,B);
        System.out.print("Lenght of LCS IS : "+getLcsLength());
        printLCS(A.length(),B.length());
    }
}
