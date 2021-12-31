package leetcode.medium;

import java.util.Arrays;

public class Leet1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i]+nums[nums.length-i-1];
            max=Math.max(max,val);
        }

        return max;
    }
}
