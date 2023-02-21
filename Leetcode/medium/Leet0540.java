package leetcode.medium;

public class Leet0540 {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int low = 0, high = nums.length - 1, ans = 0;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(mid == 0 && nums[0] != nums[1]){
                return nums[0];
            }

            if(mid == nums.length - 1 && nums[nums.length - 2] != nums[nums.length - 1]){
                return nums[nums.length - 1];
            }

            if(isNormal(mid, nums)){
                low = mid + 1;
            }else {
                ans = nums[mid];
                high = mid - 1;
            }
        }

        return ans;
    }

    public boolean isNormal(int index, int[] nums){
        if(index % 2 == 0){
            return nums[index] == nums[index + 1];
        }else {
            return nums[index - 1] == nums[index];
        }
    }
}
