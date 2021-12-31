package leetcode.easy;

import java.util.Arrays;

public class Leet1512 {
    public int numIdenticalPairs(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        int start=0,end=0;
        for (int i=0;i<nums.length;i++){
            if(i==nums.length-1){
                if(nums[i]!=nums[start]){
                    end=i-1;
                }else {
                    end=i;
                }
                sum+=(end-start+1)*(end-start)/2;
                break;
            }
            if(nums[i]!=nums[start]){
                end=i-1;
                sum+=(end-start+1)*(end-start)/2;
                start=i;
            }
        }
        return sum;
    }
}
