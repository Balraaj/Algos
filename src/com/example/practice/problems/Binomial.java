package com.example.practice.problems;

/**
 * bin(n,r) = n!/r!*(n-r)*
 * bin(3,2) = 6/2*1 = 3
 *
 * Using factorial method is going to be very very slow.
 * we can exploit the fact that bin(n,r) = bin(n-1,r-1) + bin(n-1,r)
 * using above property we can build the solution in a bottom up manner.
 */
public class Binomial {

    /**
     * Init the array required for the dynamic solution.
     * we save the intermediate calculations in the array.
     * so that we don't have to recalculate the values.
     */
    private static long[][] bin = new long[100][100];
    static{
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                bin[i][j] = -1;
            }
        }
        for(int i=0;i<100;i++){
            bin[0][i] = 0;
            bin[i][0] = 1;
            bin[i][1] = i;
            bin[i][i] = 1;
        }

        bin[0][0] = 0;
    }

    /**
     * This is dynamic solution it doesn't do extra calculations.
     * it uses extra memory to store the intermediate results,
     * so that they can be reused if required again.
     */
    private static long dynamic(int n, int r){
        if(bin[n][r] == -1){
            bin[n][r] = dynamic(n-1,r-1) + dynamic(n-1,r);
        }
        return bin[n][r];
    }

    /**
     * This is recursive solution.
     * it gets very slow for n >35, because of all the extra calculations it doing.
     */
    private static long recursive(int n, int r){
        if((n==0)||(r==0)||(n==r)){
            return 1;
        }
        else{
            return recursive(n-1, r-1) + recursive(n-1, r);
        }
    }

    public static void getNCR(int n, int r){
        long value = dynamic(n,r);
        System.out.println(n+"C"+r+" is : "+value);
    }
}
