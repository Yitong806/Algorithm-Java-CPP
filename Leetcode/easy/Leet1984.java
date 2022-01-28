package leetcode.easy;

import java.util.Arrays;

public class Leet1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.parallelSort(nums);
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            minimum = Math.min(nums[i + k - 1] - nums[i], minimum);
        }
        return minimum;
    }
}
