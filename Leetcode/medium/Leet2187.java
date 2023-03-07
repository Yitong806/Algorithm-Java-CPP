package leetcode.medium;

import java.util.Arrays;

public class Leet2187 {
    public long minimumTime(int[] time, int totalTrips) {
        long low = 0, high = (long) 1e14, ans = 1;

        while (low <= high){
            long mid = low + (high - low) / 2;
            if(accept(time, totalTrips, mid)){
                ans = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean accept(int[] time, int totalTrips, long t){
        long sum = Arrays.stream(time).mapToLong(i -> t/i).sum();
        return sum >= totalTrips;
    }
}
