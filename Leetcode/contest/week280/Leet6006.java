package leetcode.contest.week280;

import java.util.Arrays;

public class Leet6006 {
    public static long minimumRemoval(int[] beans) {
        Arrays.sort(beans);

        long[] postfix = new long[beans.length];
        for (int i = beans.length - 1; i >= 0; i--) {
            if (i == beans.length - 1) {
                postfix[i] = beans[i];
            } else {
                postfix[i] = beans[i] + postfix[i + 1];
            }
        }

        long removal = Long.MAX_VALUE;
        for (int i = 0; i < beans.length; i++) {
            long currentRemoval = (long) beans[i] * (beans.length - i) * -1 + postfix[i];
            currentRemoval += postfix[0] - postfix[i];
            removal = Math.min(removal, currentRemoval);
        }

        return removal;
    }
}
