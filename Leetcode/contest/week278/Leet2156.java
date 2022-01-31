package leetcode.contest.week278;

import java.util.HashMap;
import java.util.Map;

public class Leet2156 {
    private long[] powers;
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        buildPowers(power, k , modulo);
        for (int i = 0, length = s.length(); i < length - k + 1; i++) {
            int start = i, end = i + k;
            long hash = hash(s, start, end, power, modulo);
            hash %= modulo;
            if (hash == hashValue) {
                return s.substring(start, end);
            }
        }

        return "";
    }

    private void buildPowers(int power, int k,int  m){
        powers = new long[k];
        for (int i = 0 ; i < k ; i++){
            powers[i] = power(power, i, m);
        }
    }

    public long hash(String s, int start, int end, int power, int modulo) {
        long hash = 0;

        for (int i = start, p = 0; i < end; i++, p++) {
            //hash %= modulo;
            //hash += (val(s.charAt(i)) % modulo) * (power(power, p, modulo) % modulo) % modulo;
            hash += (val(s.charAt(i))) * (powers[p]);
            //hash %= modulo;
        }
        hash %= modulo;

        return hash;
    }

    private static int val(char c) {
        return c - 'a' + 1;
    }

    private final Map<Long, Long> powerMap = new HashMap<>();

    private long power(long power, long p, long m) {

        if(powerMap.containsKey(p)){
            return powerMap.get(p);
        }

        long originalP= p;

        power %= m;

        long answer = 1;

        while (p != 0) {
            if (p % 2 == 1) {
                answer %= m;
                answer *= power;
                answer %= m;
            }

            power %= m;
            power *= power;
            power %= m;

            p >>= 1;
        }
        powerMap.put(originalP, answer);

        return answer;
    }
}
