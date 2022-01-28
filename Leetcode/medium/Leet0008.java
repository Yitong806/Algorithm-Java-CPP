package leetcode.medium;

import java.math.BigInteger;

public class Leet0008 {
    public int myAtoi(String s) {
        char[] cs = s.toCharArray();
        StringBuilder b = new StringBuilder();

        boolean notBlank = false, isNegative = false, signed = false, numberStart = false;
        for (char c : cs) {
            if (!Character.isWhitespace(c)) {
                notBlank = true;
            }

            if (!notBlank) {
                continue;
            }

            if (c == '-' || c == '+') {
                if (signed) {
                    return b.length() == 0 ? 0 : new BigInteger(isNegative ? "-" + b.toString() : b.toString()).intValue();
                }

                if (numberStart) {
                    return new BigInteger(b.toString()).intValue();
                }

                if (c == '-') {
                    isNegative = true;
                }
                signed = true;
            } else if (Character.isDigit(c)) {
                b.append(c);
                numberStart = true;
            } else {
                break;
            }
        }

        if (b.length() == 0) {
            return 0;
        } else {
            String st = b.toString();
            BigInteger result = new BigInteger(st);
            result = isNegative ? result.multiply(BigInteger.valueOf(-1)) : result;
            if (result.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
                return Integer.MAX_VALUE;
            } else if (result.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.parseInt(isNegative ? "-" + st : st);
            }
        }
    }
}
