package leetcode.medium;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class Leet0078 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int maxPow = (int)(Math.pow(2, nums.length) - 1);

        for (int i = 0; i <= maxPow; i++) {
            StringBuilder binary = new StringBuilder(Integer.toBinaryString(i));
            binary.reverse();

            while (binary.length() < nums.length){
                binary.append("0");
            }

            binary.reverse();


            List<Integer> subset = new ArrayList<>();

            for (int j = 0; j < binary.length(); j++) {
                if(binary.charAt(j) == '1'){
                    subset.add(nums[j]);
                }
            }

            result.add(subset);
        }

        return result;
    }

}
