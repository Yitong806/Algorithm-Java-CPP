package leetcode.contest.week279;

import java.util.Arrays;

public class Leet6001 {

    public long smallestNumber(long num) {
        if(num == 0){
            return 0;
        }

        boolean negative = num < 0;
        String digitsString;
        if (negative) {
            digitsString = Long.toString(num * -1);
        } else {
            digitsString = Long.toString(num);
        }

        int zeros = 0;
        char[] digits = digitsString.toCharArray();

        for (char c : digits) {
            if (c == '0') {
                zeros++;
            }
        }
        if (!negative) {
            Arrays.sort(digits);
            StringBuilder resultBuilder = new StringBuilder();

            boolean first = false;
            for (char c : digits) {
                if (c == '0' && !first) {
                    continue;
                }
                resultBuilder.append(c);

                if (c != '0' && !first) {
                    first = true;
                    for (int i = 0; i < zeros; i++) {
                        resultBuilder.append('0');
                    }
                }


            }

            return Long.parseLong(resultBuilder.toString());
        } else {
            Arrays.sort(digits);

            StringBuilder resultBuilder = new StringBuilder();
            resultBuilder.append('-');
            for (int i = digits.length - 1; i >= 0; i--) {
                resultBuilder.append(digits[i]);
            }

            return Long.parseLong(resultBuilder.toString());
        }


    }
}
