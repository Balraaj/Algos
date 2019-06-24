package com.example.practice.problems;

import java.util.HashMap;

/**
 * Given an array of integers and a target value
 * find indices of two items whose sum is equal to the target.
 * this is two sum problem from LeetCode.
 */
public class TwoSum {
    public static int[] get(int[] nums, int target){
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            Integer pt = map.get(target-nums[i]);
            if(pt!=null)
                return new int[]{pt,i};
            map.put(nums[i],i);
        }
        return null;
    }
}
