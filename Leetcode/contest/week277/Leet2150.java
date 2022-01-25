package leetcode.contest.week277;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet2150 {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> appearTimes = new HashMap<>();
        for (int n: nums){
            if(appearTimes.containsKey(n)){
                appearTimes.put(n, appearTimes.get(n) + 1);
            }else {
                appearTimes.put(n, 1);
            }
        }

        List<Integer> lonelyNumbers = new ArrayList<>();
        for (int i:appearTimes.keySet()){
            if(appearTimes.get(i) == 1 && !appearTimes.containsKey(i + 1) && !appearTimes.containsKey(i - 1)){
                lonelyNumbers.add(i);
            }
        }

        return lonelyNumbers;
    }
}
