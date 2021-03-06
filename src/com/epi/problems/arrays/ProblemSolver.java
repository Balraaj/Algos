package com.epi.problems.arrays;

import com.example.util.Util;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A utility class for the solutions of problems
 * which doesn't warrant an individual class
 */
public class ProblemSolver {

    /**
     * This method reorders the array so that all the even numbers
     * come before the odd numbers.
     * @param array
     */
    public static void evenOdd(int[] array){
        int swapCandidate = 0;
        for(int i=0; i<array.length; i++){
            if(array[i] %2 == 0){
                Util.swap(array, swapCandidate, i);
                swapCandidate++;
            }
        }
    }

    /**
     * Rearranges the given array such that all the elements less then array[pivot]
     * come first followed by all the elements equal to array[pivot] and then
     * all the elements greater then array[pivot]
     * @param array
     * @param pivot
     */
    public static void dutchFlag(int[] array, int pivot){
        int swapCandidate = 0;
        int pivotValue = array[pivot];
        while(array[swapCandidate]<pivotValue) swapCandidate++;

        for(int i=swapCandidate; i<array.length; i++){
            if(array[i] < pivotValue){
                Util.swap(array, i , swapCandidate);
                swapCandidate++;
            }
        }

        for(int i=swapCandidate; i<array.length; i++){
            if(array[i] == pivotValue){
                Util.swap(array, i, swapCandidate);
                swapCandidate++;
            }
        }
    }

    /**
     * This method solves the dutchFlag problem in a single pass.
     * to solve the problem we divide the array into 4 sections.
     * and maintain counters smaller, equal and larger to mark the
     * boundaries of these sections.
     * @param array
     * @param pivot
     */
    public static void dutchFlagSinglePass(int[] array, int pivot){
        int equal = 0;
        int smaller = 0;
        int larger = array.length-1;

        while(equal <= larger){
            if(array[equal] < pivot){
                Util.swap(array, equal++, smaller++);
            }
            else if(array[equal] == pivot){
                equal++;
            }
            else{
                Util.swap(array, equal, larger--);
            }
        }
    }

    /**
     * Given an array of ints representing an integer,
     * this method increments that integer by one.
     * performing all operation directly on the array.
     * @param integer
     * @return
     */
    public static int[] incrementInteger(int[] integer){
        int carry = (integer[integer.length-1] + 1) / 10;
        integer[integer.length-1] = (integer[integer.length-1] + 1) % 10;

        int index = integer.length -2;
        while(index >= 0 && carry != 0){
            carry = (integer[index] + 1) / 10;
            integer[index] = (integer[index] + 1) % 10;
            index--;
        }

        if(carry==1){
            int[] newArray = new int[integer.length+1];
            newArray[0] = 1;
            int i = 1;
            for(int number : integer) newArray[i++] = number;
            return newArray;
        }
        return integer;
    }

    /**
     * This method implements the above algorithm in a better way.
     * @param integer
     */
    public static void incrementIntegerOptimized(List<Integer> integer){
        integer.set(integer.size()-1, integer.get(integer.size()-1)+1);
        int index = integer.size() - 1;
        while(index > 0 && integer.get(index) == 10){
            integer.set(index, 0);
            integer.set(index - 1, integer.get(index -1) + 1);
            index--;
        }
        if(integer.get(0)==10){
            integer.set(0, 0);
            integer.add(0, 1);
        }
    }

    /**
     * Solves the problem 6.4 of EPI.
     * returns true if the board game is winnable false otherwise.
     * @param array
     * @return
     */
    public static boolean solveBoardGame(int[] array){
        int maxReachableSoFar = 0;
        for(int i=0; i<array.length; i++) {
            maxReachableSoFar = Math.max(maxReachableSoFar, i + array[i]);
            if (maxReachableSoFar == i) return false;
        }
        return true;
    }

    /**
     * Solves the problem 6.5 of EPI.
     * deletes all the duplicate elements from the sorted array.
     */
    public static int deleteDuplicatesFromSortedArray(int[] array){
        int i = 0;
        int j = 0;
        while(i<array.length){
            Util.swap(array, i, j);
            while(i<array.length-1 && array[i]==array[i+1]) i++;
            i++;
        }
        return j;
    }

    public static int deleteDuplicateFromSortedArray2(int[] array){
        int swapCandidate = 1;
        for(int i=1; i<array.length; i++){
            if(array[swapCandidate-1] != array[i]){
                Util.swap(array, swapCandidate++, i);
            }
            else{
                swapCandidate++;
            }
        }
        return swapCandidate;
    }

    public static void maxSumSubArray(int[] array){
        int[] result = new int[3];

        int localMax = 0;
        int localStart = 0;
        int globalMax = 0;
        int globalStart = -1;
        int globalEnd = -1;

        for(int i=0;i<array.length;i++){
            localMax += array[i];
            if(localMax > globalMax){
                globalMax = localMax;
                globalStart = localStart;
                globalEnd = i;
            }
            if(localMax <= 0){
                localMax = 0;
                localStart = i+1;
            }
        }
        System.out.println("Maximum sum sub array: START: "+globalStart);
        System.out.println("Maximum sum sub array: END: "+globalEnd);
        System.out.println("Maximum sum sub array: SUM: "+globalMax);
    }

    /**
     * This method solves the problem 6.7 of EPI
     * @param array
     * @return
     */
    public static int buySellShareTwice(int[] array){
        int[] maxProfit = new int[array.length];
        int maxTotalProfit = 0;
        int maxValue = array[array.length-1];
        for(int i=array.length-2; i>=0; i--){
            maxTotalProfit = Math.max(maxTotalProfit, maxValue - array[i]);
            maxValue = Math.max(maxValue, array[i]);
            maxProfit[i] = maxTotalProfit;
        }

        int minValue = array[0];
        int maxProfitSoFar = 0;
        for(int i=1; i<array.length-1; i++) {
            maxProfitSoFar = Math.max(maxProfitSoFar, array[i] - minValue);
            minValue = Math.min(minValue, array[i]);
            maxTotalProfit = Math.max(maxTotalProfit, maxProfitSoFar + maxProfit[i+1]);
        }
        return maxTotalProfit;
    }


    /*
    There are N frustrated coders standing in a circle with a gun in their hands.
    Each coder has a skill value S[ i ] and he can only kill those coders that have strictly less skill than him.
    One more thing, all the guns have only 1 bullet. This roulette can take place in any random order.
    Fortunately, you have the time stone and you can see all possible outcomes of this scenario.
    Find the outcome where the total sum of the remaining coder's skill is minimum. Print this sum
     */
    public void killThemAll(){

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int totalSkill = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<n; i++){
            int scannerNo = s.nextInt();
            if(map.containsKey(scannerNo)){
                map.put(scannerNo, map.get(scannerNo)+1);
            }
            else{
                map.put(scannerNo,1);
            }
        }

        if(map.size()==1){
            totalSkill = map.firstEntry().getValue();
        }

        Integer key = map.higherKey(map.firstKey());
        while(key != null){
            int bullets = map.get(key);
            while(bullets > 0){
                Integer smallerKey = map.lowerKey(key);
                if(smallerKey != null){
                    if(map.get(smallerKey) == 1) map.remove(smallerKey);
                    else map.put(smallerKey, map.get(smallerKey)-1);
                }
                else{
                    break;
                }
                bullets--;
            }
            key = map.higherKey(key);
        }
        for(int k : map.keySet()){
            totalSkill = totalSkill + k*map.get(k);
        }
        System.out.println(totalSkill);
    }


    /* EPI: 6.8 Given an integer n, return a list of all the primes upto N
       Following is an implementation of 'Sieve of Eratosthenes'
     */
    public static List<Integer> findPrimesUptoN(int n){
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        List<Integer> result = new ArrayList<>();
        for(int i=2; i<n; i++){
            if(primes[i]){
                result.add(i);
                for(int j=i*i; j<n; j+=i) primes[j] = false;
            }
        }
        return result;
    }


    /**
     *EPI: 6.9: Given a string of characters and a permutation of it, return the
     * string by applying the permutation.
     * @param pattern string of characters
     * @param permutation an integer array, value stored at index i, gives the new location of
     *                    character originally at location i
     * @return
     */
    public static String permute(String pattern, int[] permutation){
        char[] patternArr = pattern.toCharArray();

        int i = 0;
        char temp;
        while(i < permutation.length){
            int j = i;
            temp = patternArr[i];
            while(permutation[j] != -1){
                char localTemp = patternArr[permutation[j]];
                patternArr[permutation[j]] = temp;
                temp = localTemp;
                int prev = permutation[j];
                permutation[j] = -1;
                j = prev;
            }
            i++;
        }

        return new String(patternArr);
    }


    /**
     * EPI: 6.10 : Write a program that takes as input a permutation, and returns the next permutation
     * under dictionary ordering. If the permutation is the last permutation, return the
     * empty array.
     * @param permutation
     * @return
     */
    public static int[] nextPermutation(int[] permutation){
        int pivotIndex = -1;
        for(int i=permutation.length-1; i>0; i--){
            if(permutation[i]>permutation[i-1]){
                pivotIndex = i-1;
                break;
            }
        }
        if(pivotIndex == -1){
            return new int[0];
        }

        for(int i=permutation.length-1; i>pivotIndex; i--){
            if(permutation[i]>permutation[pivotIndex]){
                Util.swap(permutation, i, pivotIndex);
                break;
            }
        }

        int i = pivotIndex+1;
        int j = permutation.length-1;
        while(i<j){
            Util.swap(permutation, i++, j--);
        }
        return permutation;
    }

    /**
     * Given an array and an integer k, this method rotates the array
     * k places. the direction of rotation is determined by the
     * sign of parameter k.
     * if k is negative then a right shift is performed otherwise a
     * left shift is performed.
     *
     * EX: {1,2,3,4,5,6,7,8} original array
     *     {4,5,6,7,8,1,2,3} here k is 3 or -5
     * @param array
     * @param k
     * @return
     */
    public static int[] rotateArray(int[] array, int k){
        int RIGHT_SHIFT = 1;
        int LEFT_SHIFT = 2;
        int shiftDirection = LEFT_SHIFT;
        int length = array.length;
        if(k==0) return array;
        if(k<0) {
            shiftDirection = RIGHT_SHIFT;
            k = Math.abs(k);
        }
        k = k % length;

        int start = 0;
        int end = shiftDirection == LEFT_SHIFT ? k-1 : length - k - 1;
        while(start<end){
            Util.swap(array, start++, end--);
        }

        start = shiftDirection == LEFT_SHIFT ? k : length -k;
        end = length-1;
        while(start<end){
            Util.swap(array, start++, end--);
        }

        start = 0;
        end = length-1;
        while(start<end){
            Util.swap(array, start++, end--);
        }
        return array;
    }


    /**
     * EPI: 6.11 : Given a data set and a size, return a subset of this size.
     * choice of every subset must be equally likely.
     * @param array
     * @param size
     */
    public static int[] offlineData(int[] array, int size){
        int[] result = Arrays.copyOf(array, array.length);
        for(int i=0; i<size; i++){
            Util.swap(result, i, ThreadLocalRandom.current().nextInt(i, result.length));
        }
        return result;
    }

    /**
     * EPI: 6.13: Compute a random permutation of given size.
     * every outcome must be equally likely.
     * @param size
     * @return
     */
    public static int[] randomPermutation(int size){
        int[] permutation = new int[size];
        for(int i=0; i<size; i++) {
            permutation[i] = i;
        }
        return offlineData(permutation, size);
    }
}
