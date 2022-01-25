package leetcode.contest.week277;

import java.util.Arrays;

public class Leet2148 {
    public int countElements(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();

        int elements = 0;
        for (int e : nums) {
            if (e != max && e != min) {
                elements++;
            }
        }
        return elements;
    }
}
