package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Leet0421 {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;

        for (int i = 31; i >= 0; i--) {
            mask = (1 << i) | mask;

            Set<Integer> prefixAvailableSet = new HashSet<>();
            for (int num: nums){
                prefixAvailableSet.add(num & mask);
            }

            int tempMax = (1 << i) | max;
            for (int prefix: prefixAvailableSet){
                int xor = prefix ^ tempMax;
                if(prefixAvailableSet.contains(xor)){
                    max = tempMax;
                    break;
                }
            }
        }

        return max;
    }
}
