package leetcode.contest.week275;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Leet2134 {
    public int minSwaps(int[] nums) {
        int totalN = Arrays.stream(nums).sum();
        Deque<Integer> slapWindows = new LinkedList<>();

        int current1 = 0;
        for (int i = 0; i < totalN; i++) {
            slapWindows.offer(nums[i]);
            current1 += nums[i];
        }

        int leastExchange = totalN - current1;

        for (int start = 0; start < nums.length; start++) {
            if(slapWindows.peek() != null){
                int first = slapWindows.pollFirst();
                current1 -= first;
                slapWindows.offer(nums[(start + totalN) % nums.length]);
                current1 += nums[(start + totalN) % nums.length];
                leastExchange = Math.min(totalN - current1, leastExchange);
            }
        }

        return leastExchange;
    }
}
