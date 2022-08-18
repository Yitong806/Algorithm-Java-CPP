import java.util.HashMap;
import java.util.Map;

public class Leet0137 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return -1;
    }
}
