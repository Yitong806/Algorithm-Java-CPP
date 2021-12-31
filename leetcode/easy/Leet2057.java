package leetcode.easy;

public class Leet2057 {
    public int smallestEqual(int[] nums) {
        for (int i = 0, x = 0, length = nums.length; i < length; ++i) {
            if(x == nums[i]){
                return i;
            }else {
                if(x == 9){
                    x = 0;
                }else {
                    ++x;
                }
            }
        }
        return -1;
    }
}
