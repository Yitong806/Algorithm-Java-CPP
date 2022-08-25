import java.util.Arrays;
import java.util.Comparator;

public class Leet2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        Element[] es = new Element[nums.length];
        for (int i = 0; i < nums.length; i++) {
            es[i] = new Element();
            es[i].index = i;
            es[i].value = nums[i];
        }

        Arrays.parallelSort(es, Comparator.comparingInt(e->e.value * -1));

        Arrays.parallelSort(es, 0, k, Comparator.comparingInt(e->e.index));

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = es[i].value;
        }

        return result;


    }

    private static class Element{
        int index;
        int value;
    }
}
