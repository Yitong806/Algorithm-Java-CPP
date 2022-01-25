package leetcode.hard;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Leet0514 {
    public int findRotateSteps(String ring, String key) {
        Deque<Character> ringDequeue = new LinkedList<>();
        for (char c : ring.toCharArray()) {
            ringDequeue.offer(c);
        }

        Queue<Character> keyQueue = new LinkedList<>();
        for (char c : key.toCharArray()) {
            keyQueue.offer(c);
        }

        int operations = 0;
        while (!keyQueue.isEmpty()) {
            char first = keyQueue.peek();
            char ringFirst = ringDequeue.pollFirst();
            if (ringFirst == first) {
                keyQueue.poll();
                ringDequeue.offerFirst(ringFirst);
            } else {
                ringDequeue.offer(ringFirst);
            }
            operations++;

        }

        return operations;
    }

}
