import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet2182 {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> occurrenceTime = new HashMap<>();
        for (char c: s.toCharArray()){
            occurrenceTime.putIfAbsent(c, 0);
            occurrenceTime.put(c, occurrenceTime.get(c) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o2.getKey(), o1.getKey()));

        for (Map.Entry<Character, Integer> entry: occurrenceTime.entrySet()){
            pq.offer(entry);
        }

        StringBuilder b = new StringBuilder();
        while (!pq.isEmpty()){
            Map.Entry<Character, Integer> poll = pq.poll();

            if(poll.getValue() > repeatLimit){
                for (int i = 0; i < repeatLimit; i++) {
                    b.append(poll.getKey());
                }
                poll.setValue(poll.getValue() - repeatLimit);

                if(pq.isEmpty()){
                    break;
                }
                Map.Entry<Character, Integer> secondPoll = pq.poll();

                if(secondPoll.getValue() > 1){
                    b.append(secondPoll.getKey());
                    secondPoll.setValue(secondPoll.getValue() - 1);
                    pq.offer(secondPoll);
                }else {
                    for (int i = 0; i < secondPoll.getValue(); i++) {
                        b.append(secondPoll.getKey());
                    }
                }

                pq.offer(poll);
            }else {
                for (int i = 0; i < poll.getValue(); i++) {
                    b.append(poll.getKey());
                }
            }
        }

        return b.toString();

    }
}
