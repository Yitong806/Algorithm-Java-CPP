package leetcode.contest.biweek71;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leet2163 {

    public long minimumDifference(int[] nums) {

        int n = nums.length / 3;

        long[] leftMinNSums = new long[nums.length];
        long leftNSum = 0;

        PriorityQueue<Long> minimumNNumbers = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < 2 * n; i++) {


            minimumNNumbers.offer((long) nums[i]);
            leftNSum += nums[i];

            if(minimumNNumbers.size() > n){
                leftNSum -= minimumNNumbers.poll();
            }

            leftMinNSums[i] = leftNSum;
        }

        System.out.println(Arrays.toString(leftMinNSums));


        long[] rightNSums = new long[nums.length];
        long rightNSum = 0;
        PriorityQueue<Long> maximumNNumbers = new PriorityQueue<>(Comparator.naturalOrder());

        for (int i = 3*n - 1; i >=  n - 1; i--) {
            if(i == 3 * n - 1){
                rightNSum += 0;
                rightNSums[i] = 0;
                continue;
            }

            maximumNNumbers.offer((long) nums[i + 1]);
            rightNSum += nums[i + 1];

            if(maximumNNumbers.size() > n){
                rightNSum -= maximumNNumbers.poll();
            }

            rightNSums[i] = rightNSum;

        }
        System.out.println(Arrays.toString(rightNSums));

        long answer = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i ++){
            System.out.println(leftMinNSums[i] + " "+rightNSums[i]);
            answer = Math.min(answer, leftMinNSums[i]- rightNSums[i]);
        }

        return answer;
    }
}
