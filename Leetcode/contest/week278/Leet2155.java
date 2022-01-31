package leetcode.contest.week278;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Leet2155 {
    int sum;

    public List<Integer> maxScoreIndices(int[] nums) {
        setSum(nums);
        int[] numsLeft = numsLeft(nums);
        int[] numsRight = numsRight(nums);
        return calculate(numsLeft, numsRight);
    }

    public void setSum(int[] nums){
        sum = Arrays.stream(nums).sum();
    }

    public int[] numsLeft(int[] nums){
        int current0 = 0;
        int[] count0 = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            count0[i] = current0;
            if(nums[i] == 0){
                current0 += 1;
            }
        }

        count0[nums.length] = nums.length - sum;

        return count0;
    }

    public int[] numsRight(int[] nums){
        int current1 = 0;
        int[] count1 = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; i--){

            if(nums[i] == 1){
                current1 ++;
            }
            count1[i] = current1;
        }

        count1[nums.length] = 0;

        return count1;
    }

    public List<Integer> calculate(int[] numsLeft, int[] numsRight){
        int maxScore = 0;
        for (int i = 0; i < numsLeft.length; i++) {
            int score = numsLeft[i] + numsRight[i];
            maxScore = Math.max(maxScore, score);
        }

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < numsLeft.length; i++) {
            int score = numsLeft[i] + numsRight[i];
            if(score == maxScore){
                list.add(i);
            }
        }

        return list;
    }
}
