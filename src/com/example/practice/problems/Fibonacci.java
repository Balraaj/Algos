package com.example.practice.problems;


/**
 * Problem is defined by recurrence F(n) = F(n-1)+F(n-2)
 * Recursion seems the natural choice to solve the problem.
 */
public class Fibonacci {

    public static void get(int n){
        long nthFibonacci = fibDynamic(n);
        System.out.println(n+"th fibonacci no is : "+nthFibonacci);
    }

    /**
     * This solution gets slower around 50th term, because its doing lot of unnecessary computation.
     */
    private static int fibRecursive(int n){
        if(n==0){return 0;}
        if(n==1){return 1;}
        return fibRecursive(n-1)+ fibRecursive(n-2);
    }

    /**
     * This solution is lot faster then the above solution because it does no extra calculation.
     */
    private static long fibIterative(int n){
        if(n==0) return 0;
        if(n==1) return 1;

        long x = 0;
        long y = 1;
        long z = 0;
        for(int i=2;i<=n;i++){
            z = x+y;
            x = y;
            y = z;
        }
        return z;
    }


    /**
     * This solution is almost as fast as iterative solution.
     * Essentially its the same recursive solution as above,
     * but it uses extra space to reduce the extra computation.
     */
    private static long fibDynamic(int n){
        if(terms[n]==-1){
            terms[n] = fibDynamic(n-1) + fibDynamic(n-2);
        }
        return terms[n];
    }

    /**
     * Set up the array to be used by dynamic solution.
     */
    private static long[] terms = new long[200];
    static{
        terms[0] = 0;
        terms[1] = 1;
        for(int i=2;i<200;i++) terms[i] = -1;
    }

    public static void main(String[] args){
       get(10);
    }
}
