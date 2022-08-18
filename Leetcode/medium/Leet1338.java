import java.util.*;

public class Leet1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> occurrenceTimes = new HashMap<>();
        for (int a: arr){
            occurrenceTimes.putIfAbsent(a, 0);
            occurrenceTimes.put(a, occurrenceTimes.get(a) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(occurrenceTimes.entrySet());
        entryList.sort(Comparator.comparingInt(Map.Entry::getValue));

        int minSize = 0;
        int removedElements = 0;
        for (int i = entryList.size() - 1; i >= 0; i--) {
            minSize += 1;
            removedElements += entryList.get(i).getValue();
            if(removedElements >= arr.length / 2){
                break;
            }
        }

        return minSize;
    }
}
