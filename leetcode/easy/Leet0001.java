package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class Leet0001 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>hashMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int j=0;j< nums.length;j++){
            int needed=target-nums[j];
            if(hashMap.containsKey(needed)&&hashMap.get(needed)!=j){
                return new int[]{j,hashMap.get(needed)};
            }
        }
        return new int[2];
    }
}
