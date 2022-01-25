package leetcode.medium;

import java.util.Arrays;

public class Leet0875 {
    public int minEatingSpeed(int[] piles, int h) {
        long sum = Arrays.stream(piles).asLongStream().sum();
        long lowK = 1, highK = sum, answerK = 1;

        while (lowK <= highK){
            long midK = (lowK + highK) >> 1;
            if(isOK(piles, h, midK)){
                answerK = midK;
                highK = midK - 1;
            }else {
                lowK = midK + 1;
            }
        }

        return (int) answerK;
    }

    private boolean isOK(int[] piles, int h, long midK){
        int used = 0;
        for (int p: piles){
            used += Math.ceil(p * 1.0 / midK);
        }
        return used <= h;
    }
}
