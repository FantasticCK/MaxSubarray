package com.CK;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        greedySolution solution = new greedySolution();
        System.out.println(solution.maxSubArray(arr));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = i ; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }
}

class greedySolution {
    public int maxSubArray(int[] nums){
        int currentSum = nums[0];
        int maxSum  = nums[0];

        for (int i=0;i<nums.length;i++){
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }
}

class DPSolution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}