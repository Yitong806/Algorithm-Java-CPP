package leetcode.medium;

import javafx.util.Pair;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Leet1887 {
    public int reductionOperations(int[] nums) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (e1, e2) -> Integer.compare(e2.getKey(), e1.getKey()));
        Map<Integer, Integer> elementAppearTimes = new HashMap<>();
        int answer = 0;

        Arrays.stream(nums).forEach(n -> {
            elementAppearTimes.putIfAbsent(n, 0);
            elementAppearTimes.put(n, elementAppearTimes.get(n) + 1);
        });

        elementAppearTimes.entrySet().forEach(pq::offer);

        while (pq.size() > 1){
            Map.Entry<Integer, Integer> largestKeyEntry = pq.poll();
            Map.Entry<Integer, Integer> secondKeyEntry = pq.poll();
            answer += largestKeyEntry.getValue();
            secondKeyEntry.setValue(secondKeyEntry.getValue() + largestKeyEntry.getValue());
            pq.offer(secondKeyEntry);
        }

        return answer;
    }
}
