package leetcode.easy;

public class Leet0035 {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                ans = mid;
                break;
            }else if(nums[mid] < target){
                ans = mid;
                low = mid + 1;
            }else {
                ans = mid + 1;
                high = mid - 1;
            }
        }

        return ans;
    }
}
