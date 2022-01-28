package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet0491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        isContains = new boolean[nums.length];
        buildLists(nums, 0);
        return new ArrayList<>(result);

    }

    private final Set<List<Integer>> result = new HashSet<>();
    private boolean[] isContains;

    private void buildLists(int[] originalIntegers, int currentContainsIndex) {
        if (currentContainsIndex == isContains.length) {
            List<Integer> subList = new ArrayList<>();
            int previousValue = Integer.MIN_VALUE;
            for (int i = 0; i < isContains.length; i++) {
                if(isContains[i]){
                    if(originalIntegers[i] < previousValue){
                        return;
                    }else {
                        subList.add(originalIntegers[i]);
                        previousValue = originalIntegers[i];
                    }
                }
            }
            if (subList.size() >= 2) {
                result.add(subList);
            }
            return;
        }

        isContains[currentContainsIndex] = true;
        buildLists(originalIntegers, currentContainsIndex + 1);

        isContains[currentContainsIndex] = false;
        buildLists(originalIntegers, currentContainsIndex + 1);
    }


}
