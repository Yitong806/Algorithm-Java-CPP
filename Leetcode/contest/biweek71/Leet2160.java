package leetcode.contest.biweek71;

import java.util.Arrays;

public class Leet2160 {

    public int minimumSum(int num) {
        int[] nums = {num / 1000, num % 1000 / 100, num % 100 / 10, num % 10};
        Arrays.sort(nums);

        return Math.min(nums[0] * 10 + nums[2] + nums[1] * 10 + nums[3], nums[0] * 10 + nums[3] + nums[1] * 10 + nums[2]);
    }
}
