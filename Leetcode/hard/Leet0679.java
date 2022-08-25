import java.util.HashSet;
import java.util.Set;

public class Leet0679 {

    public boolean judgePoint24(int[] cards) {
        double[] ds = {cards[0], cards[1], cards[2], cards[3]};
        return dfs(ds);
    }

    final char[] ops = {'+','-','*','/'};

    private boolean dfs(double[] values){
        if(values.length == 1 && Math.abs(values[0] - 24) <= 0.01){
            return true;
        }

        Set<Integer> set0123 = new HashSet<>();
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                if(i == j){
                    continue;
                }

                for (int k = 0; k < values.length; k++) {
                    set0123.add(k);
                }

                set0123.remove(i);
                set0123.remove(j);

                for (int k = 0; k < 4; k++) {
                    double[] nextValues = new double[values.length - 1];
                    nextValues[0] = cal(values[i], values[j], ops[k]);

                    int s = 1;
                    for (int index: set0123){
                        nextValues[s++] = values[index];
                    }

                    if(dfs(nextValues)){
                        return true;
                    }
                }


            }
        }

        return false;

    }


    private double cal(double v1, double v2, char op){
        switch (op) {
            case '+' -> {
                return v1 + v2;
            }
            case '-' -> {
                return v1 - v2;
            }
            case '*' -> {
                return v1 * v2;
            }
            case '/' -> {
                return v1 / v2;
            }
        }

        return -1;
    }
}
