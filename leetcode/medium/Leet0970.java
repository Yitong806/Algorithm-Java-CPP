package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet0970 {
    final Set<Integer> powX = new HashSet<>();
    final Set<Integer> powY = new HashSet<>();
    int logX;
    int logY;
    boolean unused = true;

    final Set<Integer> answer = new HashSet<>();

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        buildPower(bound, x);
        buildPower(bound, y);

        for (int i = 0; i <= logX; i++) {
            for (int j = 0; j <= logY; j++) {
                int powed = (int) (Math.pow(x, i) + Math.pow(y, j));
                if(powed <= bound){
                    answer.add(powed);
                }

            }
        }

        return new ArrayList<>(answer);
    }

    void buildPower(int bound, int value) {
        if(value == 1){
            if(unused){
                logX = 0;
                powX.add(1);
            }else {
                logY = 0;
                powY.add(1);
            }
            unused = !unused;
            return;
        }

        int log = 0;
        int current = 1;
        while (current <= bound) {
            if (unused) {
                powX.add(current);
            } else {
                powY.add(current);
            }
            current *= value;
            log++;
        }

        if (unused) {
            logX = log;
        } else {
            logY = log;
        }

        unused = !unused;
    }
}
