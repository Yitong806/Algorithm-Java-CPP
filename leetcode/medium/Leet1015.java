package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Leet1015 {
    public int smallestRepunitDivByK(int k) {
        int remainder = 1, currentLength = 1;
        Set<Integer> remainders = new HashSet<>();

        if(remainder % k  == 0){
            return 1;
        }

        while (true){
            int currentRemainder = ((remainder * 10) + 1) % k;
            currentLength++;
            if(currentRemainder == 0){
                return currentLength;
            }

            if(remainders.contains(currentRemainder)){
                return -1;
            }

            remainders.add(currentRemainder);
            remainder = currentRemainder;
        }
    }
}
