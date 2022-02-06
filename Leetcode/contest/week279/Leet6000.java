package leetcode.contest.week279;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Leet6000 {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> odd = new ArrayList<>(), even = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if(i % 2 ==0){
                even.add(nums[i]);
            }else {
                odd.add(nums[i]);
            }
        }


        odd.sort(Comparator.reverseOrder());
        int oddIndex = 0, evenIndex = 0;
        even.sort(Comparator.naturalOrder());

        for (int i = 0; i < nums.length; i++) {
            if(i % 2 ==0){
                nums[i] = even.get(evenIndex++);
            }else {
                nums[i] = odd.get(oddIndex++);
            }
        }

        return nums;
    }
}
