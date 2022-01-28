package leetcode.medium;

public class Leet1470 {
    public int[] shuffle(int[] nums, int n) {
        int[] output = new int[2 * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            output[index] = nums[i];
            output[index + 1] = nums[i + n];
            index += 2;
        }
        return output;
    }
}
