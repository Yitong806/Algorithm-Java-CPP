package luogu.main.simulation_highPrecision;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1591 {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        int t = fastReader.nextInt();
        for (int i = 0; i < t; i++) {
            int n = fastReader.nextInt();
            char a = fastReader.next().charAt(0);
            long[] pow = calculate(n);
            //System.out.println(Arrays.toString(pow));

            fastWriter.println(getA(pow, a));
        }

        fastReader.close();
        fastWriter.close();
    }

    private static int getA(long[] pow, char a) {
        int cnt = 0;
        boolean no0 = false;
        for (long l : pow) {
            if (l != 0) {
                no0 = true;
            }
            if (!no0) {
                continue;
            }

            if (l + '0' == a) {
                cnt++;
            }
        }

        return cnt;
    }

    private static long[] calculate(int n) {
/*
        BigInteger bi = BigInteger.ONE;
        for (int i = 2; i < n; i++) {
            bi = bi.multiply(BigInteger.valueOf(i));
        }

        String s = bi.toString();
        long[] re = new long[s.length()];
        for (int i = 0; i < s.length(); i++) {
            re[i] = s.charAt(i) - '0';
        }

        return re;*/
        long[] pow = new long[]{1};

        for (int i = 1; i <= n; i++) {
            String v = String.valueOf(i);
            long[] nString = new long[v.length()];
            for (int j = 0; j < nString.length; j++) {
                nString[j] = v.charAt(j) - '0';
            }

            pow = multiply(pow, nString);
        }

        return pow;
    }

    private static long[] multiply(long[] s1, long[] s2) {
        long[] result = new long[s1.length + s2.length];

        for (int i = s1.length - 1; i >= 0; i--) {

            long carry = 0;
            for (int j = s2.length - 1; j >= 0 || carry != 0; j--) {
                long number = carry + result[i + j + 1];

                if (j >= 0) {
                    number += s1[i] * s2[j];
                }

                carry = number / 10;
                number %= 10;

                result[i + j + 1] = number;
            }
        }

        return result;
    }

    private static class FastReader implements Closeable {
        private final BufferedReader br;
        private StringTokenizer st;

        public FastReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in), 16384);
            eat("");
        }

        private void eat(String s) {
            st = new StringTokenizer(s);
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public boolean hasNext() {
            while (!st.hasMoreTokens()) {
                String s = nextLine();
                if (s == null) return false;
                eat(s);
            }
            return true;
        }

        public String next() {
            hasNext();
            return st.nextToken();
        }

        public boolean nextBoolean() {
            return Boolean.parseBoolean(next());
        }


        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        public BigDecimal nextBigDecimal() {
            return new BigDecimal(next());
        }

        public void close() {
            try {
                st = null;
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }

        }
    }

    private static class FastWriter implements Closeable {
        private final PrintWriter writer;

        public FastWriter(OutputStream out) {
            this.writer = new PrintWriter(out);
        }

        public void print(Object object) {
            writer.write(object.toString());
        }

        public void printf(String format, Object... os) {
            writer.write(String.format(format, os));
        }

        public void println() {
            writer.write(System.lineSeparator());
        }

        public void println(Object object) {
            writer.write(object.toString());
            writer.write(System.lineSeparator());
        }

        @Override
        public void close() {
            writer.close();
        }
    }
}
