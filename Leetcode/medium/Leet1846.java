import java.util.Arrays;

public class Leet1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.parallelSort(arr);
        int increasingNumber = 1;

        for (int a: arr){
            if(a >= increasingNumber){
                increasingNumber++;
            }
        }

        return increasingNumber - 1;

    }
}
