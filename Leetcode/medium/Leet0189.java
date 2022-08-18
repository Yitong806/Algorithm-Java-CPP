import java.util.Arrays;

public class Leet0189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0 , nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    private void reverse(int[] nums, int start, int end){
        for (int i = 0; i <= end - start; i++){
            int index1 = start + i, index2 = end - i;
            if(index1 >= index2){
                break;
            }

            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }

}
