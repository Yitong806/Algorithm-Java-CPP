package leetcode.medium;

import java.util.Arrays;

public class Leet1011 {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = Arrays.stream(weights).sum();
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (portable(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean portable(int[] weights, int days, int capacity) {
        int index = 0, currentCapacity = capacity;
        while (days > 0 && index < weights.length) {
            if (weights[index] <= currentCapacity) {
                currentCapacity -= weights[index];
                index++;
            } else {
                currentCapacity = capacity;
                days--;
            }
        }

        return days >= 0 && index >= weights.length;
    }
}
