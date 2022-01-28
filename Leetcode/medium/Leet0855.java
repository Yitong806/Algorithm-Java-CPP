package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leet0855 {
    private static class ExamRoom {

        private final int size;

        private final PriorityQueue<Integer> usedPlace = new PriorityQueue<>();
        private final Map<Integer, ExamRoom.Interval> intervalLeftMap = new HashMap<>();
        private final Map<Integer, ExamRoom.Interval> intervalRightMap = new HashMap<>();
        private final PriorityQueue<ExamRoom.Interval> usedIntervals = new PriorityQueue<>();

        public ExamRoom(int n) {
            this.size = n;
        }

        public int seat() {
            if (this.usedPlace.isEmpty()) {
                usedPlace.offer(0);
                return 0;
            } else if (this.usedPlace.size() == 1) {
                int left1 = this.usedPlace.peek();
                int differenceRight = this.size - left1 - 1;
                int maxPlace;
                if (differenceRight > left1) {
                    maxPlace = this.size - 1;
                    usedPlace.offer(maxPlace);
                    ExamRoom.Interval in = new ExamRoom.Interval(left1, maxPlace);
                    intervalLeftMap.put(left1, in);
                    intervalRightMap.put(maxPlace, in);
                    usedIntervals.offer(in);
                } else {
                    maxPlace = 0;
                    usedPlace.offer(maxPlace);
                    ExamRoom.Interval in = new ExamRoom.Interval(maxPlace, left1);
                    intervalLeftMap.put(maxPlace, in);
                    intervalRightMap.put(left1, in);
                    usedIntervals.offer(in);
                }

                return maxPlace;
            } else {
                ExamRoom.Interval leftEmpty = new ExamRoom.Interval(0, this.usedPlace.peek());
                leftEmpty.maximalClosest = leftEmpty.end;

                int maxRight = -1;
                for (Integer i : this.usedPlace) {
                    maxRight = Math.max(maxRight, i);
                }

                ExamRoom.Interval rightEmpty = new ExamRoom.Interval(maxRight, this.size - 1);
                rightEmpty.maximalClosest = rightEmpty.end - rightEmpty.start;

                ExamRoom.Interval maxInterval = this.usedIntervals.peek();

                PriorityQueue<ExamRoom.Interval> tempSorter = new PriorityQueue<>();
                tempSorter.offer(leftEmpty);
                tempSorter.offer(rightEmpty);
                tempSorter.offer(maxInterval);

                ExamRoom.Interval currentMaxInterval = tempSorter.peek();
                int middle;
                assert currentMaxInterval != null;
                if (currentMaxInterval == maxInterval) {
                    this.usedIntervals.poll();
                    middle = currentMaxInterval.middle;
                }else if(currentMaxInterval == leftEmpty){
                    middle = 0;
                }else {
                    middle = this.size - 1;
                }

                usedPlace.offer(middle);

                int left = currentMaxInterval.start;
                int right = currentMaxInterval.end;

                ExamRoom.Interval leftInterval = new ExamRoom.Interval(left, middle);
                ExamRoom.Interval rightInterval = new ExamRoom.Interval(middle, right);

                if(leftInterval.start != leftInterval.end){
                    usedIntervals.offer(leftInterval);
                    intervalLeftMap.put(left, leftInterval);
                    intervalRightMap.put(middle, leftInterval);
                }

                if(rightInterval.start  != rightInterval.end){
                    usedIntervals.offer(rightInterval);
                    intervalLeftMap.put(middle, rightInterval);
                    intervalRightMap.put(right, rightInterval);
                }

                return middle;
            }
        }

        public void leave(int p) {
            usedPlace.remove(p);
            ExamRoom.Interval left = intervalRightMap.get(p);
            ExamRoom.Interval right = intervalLeftMap.get(p);

            if (left != null && right != null) {
                usedIntervals.remove(left);
                usedIntervals.remove(right);

                ExamRoom.Interval merged = new ExamRoom.Interval(left.start, right.end);
                usedIntervals.offer(merged);

                intervalLeftMap.remove(right.start);
                intervalRightMap.remove(left.end);

                intervalLeftMap.put(left.start, merged);
                intervalRightMap.put(right.end, merged);
            }

            if (left == null && right != null) {
                usedIntervals.remove(right);
                intervalLeftMap.remove(right.start);
                intervalRightMap.remove(right.end);
            }

            if (left != null && right == null) {
                usedIntervals.remove(left);
                intervalLeftMap.remove(left.start);
                intervalRightMap.remove(left.end);
            }

        }

        private static class Interval implements Comparable<ExamRoom.Interval> {
            int start;
            int end;
            int maximalClosest;
            int middle;

            public Interval(int start, int end) {
                this.start = start;
                this.end = end;
                this.middle = (start + end) / 2;
                this.maximalClosest = Math.min(this.middle - this.start, this.end - this.middle);
            }

            @Override
            public int compareTo(ExamRoom.Interval o) {
                if (this.maximalClosest != o.maximalClosest) {
                    return Integer.compare(this.maximalClosest, o.maximalClosest) * -1;
                } else {
                    return Integer.compare(this.middle, o.middle);
                }
            }
        }
    }
}


