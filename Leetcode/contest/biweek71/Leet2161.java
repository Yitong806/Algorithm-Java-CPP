package leetcode.contest.biweek71;

import java.util.ArrayList;
import java.util.List;

public class Leet2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> bigger = new ArrayList<>(100006);
        List<Integer> smaller = new ArrayList<>(100006);
        List<Integer> equals = new ArrayList<>(100006);

        for (int v : nums) {
            if (v > pivot) {
                bigger.add(v);
            } else if (v < pivot) {
                smaller.add(v);
            } else {
                equals.add(v);
            }
        }

        smaller.addAll(equals);
        smaller.addAll(bigger);

        int[] result = new int[smaller.size()];
        for (int i = 0; i < smaller.size(); i++) {
            result[i] = smaller.get(i);
        }

        return result;
    }
}
