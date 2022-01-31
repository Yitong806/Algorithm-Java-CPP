package leetcode.contest.week278;

public class Leet2154 {
    public int findFinalValue(int[] nums, int original) {
        boolean[] isContains = new boolean[1005];

        for (int num : nums) {
            isContains[num] = true;
        }

        while (original < isContains.length && isContains[original]){
            original *= 2;
        }

        return original;
    }
}
