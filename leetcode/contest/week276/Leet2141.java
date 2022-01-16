package leetcode.contest.week276;

import java.util.Arrays;

public class Leet2141 {

    public long maxRunTime(int n, int[] batteries) {
        long sum = batteriesSum(batteries);

        long low = 0, high = sum / n, answer = 0;
        while (low <= high){
            long mid = (low + high) >> 1;
            if(isOK(mid, n , batteries)){
                answer = mid;
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return answer;
    }

    private boolean isOK(long mid, int n, int[] batteries){
        long batterySum = 0 , batteryRequired = mid * n;

        for (int battery: batteries){
            batterySum += Math.min(battery, mid);
            if(batterySum >  batteryRequired){
                return true;
            }
        }
        return batterySum > batteryRequired;
    }

    private long batteriesSum(int[] batteries){
        return Arrays.stream(batteries).asLongStream().sum();
    }
}
