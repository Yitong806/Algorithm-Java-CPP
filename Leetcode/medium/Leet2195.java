import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class Leet2195 {
    public long minimalKSum(int[] nums, int k) {
        Arrays.parallelSort(nums);

        long sum = (long) k * (k + 1) / 2;

        long maximum = k;

        int prev = -1;

        for (int i: nums){
            if(i == prev){
                continue;
            }

            if(i > maximum){
                break;
            }else {
                sum -= i;
                maximum += 1;
                sum += maximum;
            }
            prev = i;
        }

        return sum;
    }
}
