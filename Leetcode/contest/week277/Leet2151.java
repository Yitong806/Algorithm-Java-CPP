package leetcode.contest.week277;

import java.util.Arrays;

public class Leet2151 {

    public int maximumGood(int[][] statements) {
        int people = statements.length;

        int maxPossibleCount = (int) (Math.pow(2, people) - 1);

        int maxGood = 0;
        for (int i = 0; i <= maxPossibleCount; i++) {
            boolean[] badGoods = badGoodTransform(i, statements.length);
            if (checkIsValid(statements, badGoods)) {
                System.out.println(Arrays.toString(badGoods));
                maxGood = Math.max(maxGood, countGood(badGoods));
            }
        }

        return maxGood;
    }

    private int countGood(boolean[] badGoods) {
        int cnt = 0;
        for (boolean bg : badGoods) {
            if (!bg) {
                cnt++;
            }
        }

        return cnt;
    }

    private boolean checkIsValid(int[][] statement, boolean[] actualBadGoods) {
        for (int i = 0; i < statement.length; i++) {
            if (!checkSinglePerson(statement[i], actualBadGoods, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSinglePerson(int[] statement, boolean[] badGoods, int index) {
        if (!badGoods[index]) {
            return true;
        }

        for (int j = 0; j < statement.length; j++) {
            if (statement[j] == 2) {
                continue;
            }
            if (badGoods[j] != (statement[j] == 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean[] badGoodTransform(int count, int peopleCount) {

        char[] bg = binaryString(count, peopleCount).toCharArray();
        boolean[] badGoods = new boolean[peopleCount];
        for (int i = 0; i < peopleCount; i++) {
            if(i < bg.length){
                badGoods[i] = bg[i] == '1';
            }else {
                badGoods[i] = false;
            }
        }

        return badGoods;
    }

    private String binaryString(int count, int peopleCount){
        StringBuilder b = new StringBuilder(Integer.toBinaryString(count));

        while (b.length() < peopleCount){
            b.insert(0,'0');
        }

        return b.toString();
    }
}
