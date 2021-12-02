package luogu.main.simulation_highPrecision;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1098 {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);
        int p1 = fastReader.nextInt(), p2 = fastReader.nextInt(), p3 = fastReader.nextInt();
        String line = fastReader.next();
        fastWriter.println(parse(p1, p2, p3, line));

        fastReader.close();
        fastWriter.close();
    }

    private static String parse(int p1, int p2, int p3, String line) {
        char[] cs = line.toCharArray();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '-' && i < cs.length - 1 && i > 0) {
                char before = cs[i - 1], after = cs[i + 1];
                if (isSameType(before, after) && before < after) {
                    b.append(buildString((char) (before + 1), (char) (after - 1), p1, p2, p3));
                } else {
                    b.append(cs[i]);
                }
            } else {
                b.append(cs[i]);
            }
        }

        return b.toString();
    }

    private static boolean isSameType(char c1, char c2) {
        return (Character.isDigit(c1) && Character.isDigit(c2))
                ||
                (Character.isLowerCase(c1) && Character.isLowerCase(c2));
    }

    private static String buildString(char start, char end, int p1, int p2, int p3) {
        StringBuilder b = new StringBuilder();
        for (char c = start; c <= end; c++) {
            for (int i = 0; i < p2; i++) {
                switch (p1) {
                    case 1: {
                        b.append(Character.toLowerCase(c));
                        break;
                    }

                    case 2: {
                        b.append(Character.toUpperCase(c));
                        break;
                    }

                    case 3: {
                        b.append("*");
                        break;
                    }
                }
            }
        }

        if (p3 == 2) {
            b.reverse();
        }

        return b.toString();
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
