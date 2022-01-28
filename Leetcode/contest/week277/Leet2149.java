package leetcode.contest.week277;

import java.util.LinkedList;
import java.util.Queue;

public class Leet2149 {

    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> positiveQueue = new LinkedList<>();
        Queue<Integer> negativeQueue = new LinkedList<>();
        for (int n : nums) {
            if(n > 0){
                positiveQueue.offer(n);
            }else {
                negativeQueue.offer(n);
            }
        }

        int[] result = new int[nums.length];
        int index = 0;
        while (!positiveQueue.isEmpty() && !negativeQueue.isEmpty()){
            result[index++] = positiveQueue.poll();
            result[index++] = negativeQueue.poll();
        }

        return result;
    }
}
