package leetcode.contest.week275;

import java.util.Arrays;

public class Leet2133 {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        boolean[] contains = new boolean[n];
        for (int[] ints : matrix) {
            Arrays.fill(contains, false);
            for (int j = 0; j < n; j++) {
                contains[ints[j] - 1] = true;
            }

            for (boolean b : contains) {
                if (!b) {
                    return false;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(contains, false);
            for (int[] ints : matrix) {
                contains[ints[i] - 1] = true;
            }

            for (boolean b : contains) {
                if (!b) {
                    return false;
                }
            }
        }

        return true;
    }
}
