package leetcode.medium;

public class Leet1558 {
    public int minOperations(int[] nums) {
        int step = 0;
        int maxPower = 0;
        for (int i : nums) {
            int power = 0;
            while (i != 0) {
                if (i % 2 == 0) {
                    i /= 2;
                    power++;
                } else {
                    i -= 1;
                    step++;
                }

            }

            maxPower = Math.max(maxPower, power);
        }

        step += maxPower;
        //step += nums.length;

        return step;
    }
}
