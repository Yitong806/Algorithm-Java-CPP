package leetcode.contest.week275;

import java.util.Arrays;

public class Leet2136 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        Flower[] flowers = new Flower[plantTime.length];
        for (int i = 0; i < plantTime.length; i++) {
            flowers[i] = new Flower(plantTime[i], growTime[i]);
        }

        Arrays.sort(flowers, (o1, o2) -> Integer.compare(o2.growTime, o1.growTime));
        int usedTime = 0;
        int answer = 0;
        for (int i = 0; i < plantTime.length; i++) {
            usedTime += flowers[i].plantTime;
            answer = Math.max(answer, usedTime + flowers[i].growTime);
        }

        return answer;
    }

    private static class Flower{
        int plantTime;
        int growTime;

        public Flower(int p, int g){
            this.plantTime = p;
            this.growTime = g;
        }
    }
}
