package leetcode.easy;

import java.util.Arrays;

public class Leet1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int[]ac : accounts){
            max  = Math.max(max, Arrays.stream(ac).sum());
        }
        return max;
    }
}
