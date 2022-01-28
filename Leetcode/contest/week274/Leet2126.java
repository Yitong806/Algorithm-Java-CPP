package leetcode.contest.week274;

import java.util.Arrays;

public class Leet2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long t = mass;
        for (int a: asteroids){
            if(mass < a){
                return false;
            }else {
                t += a;
            }
        }
        return true;
    }
}
