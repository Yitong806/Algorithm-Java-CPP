package leetcode.medium;

public class Leet1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count60 = new int[60];
        for (int t : time) {
            count60[t % 60]++;
        }

        int result = 0;
        for (int i = 1; i < 30; i++) {
            result += count60[i] * count60[60- i];
        }
        result += count60[30] * (count60[30] - 1) / 2;
        result += count60[0] * (count60[0] - 1) / 2;

        return result;
    }
}
