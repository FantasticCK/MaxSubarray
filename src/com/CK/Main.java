package com.CK;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        Solution3 solution = new Solution3();
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


/**
 *   Divide and Conquer
 */
class Solution3 {
    public int crossSum(int[] nums, int left, int right, int p) {
        if (left == right) return nums[left];

        int leftSubsum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = p; i > left - 1; --i) {
            currSum += nums[i];
            leftSubsum = Math.max(leftSubsum, currSum);
        }

        int rightSubsum = Integer.MIN_VALUE;
        currSum = 0;
        for(int i = p + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSubsum = Math.max(rightSubsum, currSum);
        }

        return leftSubsum + rightSubsum;
    }

    public int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int p = (left + right) / 2;

        int leftSum = helper(nums, left, p);
        int rightSum = helper(nums, p + 1, right);
        int crossSum = crossSum(nums, left, right, p);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}