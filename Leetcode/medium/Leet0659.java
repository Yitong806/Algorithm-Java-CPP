import java.util.*;

public class Leet0659 {
    public boolean isPossible(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        Map<Integer, Integer> appearTimes = new HashMap<>();
        Map<Integer, Integer> endingSequenceNumbers = new HashMap<>();

        for (int j : nums) {
            appearTimes.putIfAbsent(j, 0);
            appearTimes.put(j, appearTimes.get(j) + 1);
        }

        for (int num: nums){
            if(appearTimes.get(num) == 0){
                continue;
            }

            appearTimes.putIfAbsent(num + 1, 0);
            appearTimes.putIfAbsent(num + 2, 0);
            appearTimes.put(num, appearTimes.get(num) - 1);
            endingSequenceNumbers.putIfAbsent(num - 1, 0);
            endingSequenceNumbers.putIfAbsent(num, 0);
            endingSequenceNumbers.putIfAbsent(num + 1, 0);
            endingSequenceNumbers.putIfAbsent(num + 2, 0);

            if(endingSequenceNumbers.get(num - 1) != 0){
                endingSequenceNumbers.put(num - 1, endingSequenceNumbers.get(num - 1) - 1);
                endingSequenceNumbers.put(num, endingSequenceNumbers.get(num) + 1);
            }else if(appearTimes.get(num+1) > 0 && appearTimes.get(num + 2) > 0){
                appearTimes.put(num +1, appearTimes.get(num + 1) - 1);
                appearTimes.put(num + 2, appearTimes.get(num + 2) - 1);
                endingSequenceNumbers.put(num + 2, endingSequenceNumbers.get(num +  2) + 1);
            }else {
                return false;
            }

        }

        return true;
    }
}
