import java.util.Arrays;

public class Leet0922 {
    public int[] sortArrayByParityII(int[] nums) {
        int oddIndex = 1, evenIndex = 0;

        while (true){
            while (oddIndex < nums.length && nums[oddIndex] % 2 == 1){
                oddIndex += 2;
            }

            while (evenIndex < nums.length && nums[evenIndex] % 2 == 0){
                evenIndex += 2;
            }

            if(oddIndex < nums.length && evenIndex < nums.length){
                int temp = nums[oddIndex];
                nums[oddIndex] = nums[evenIndex];
                nums[evenIndex] = temp;
            }else {
                break;
            }
        }

        return nums;

    }
}
