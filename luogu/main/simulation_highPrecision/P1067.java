package luogu.main.simulation_highPrecision;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1067 {

    private static final FastReader fastReader = new FastReader(System.in);
    private static final FastWriter fastWriter = new FastWriter(System.out);

    public static void main(String[] args) {
        int n = fastReader.nextInt();
        int[] coefficient = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            coefficient[i] = fastReader.nextInt();
        }
        printResult(coefficient, n);
        fastReader.close();
        fastWriter.close();
    }

    private static void printResult(int[] coefficient, int n) {
        StringBuilder b = new StringBuilder();
        if (n >= 2 && coefficient[0] != 0) {
            if (coefficient[0] > 0) {
                if(b.length() != 0){
                    b.append("+");
                }
            } else {
                b.append("-");
            }
            if (Math.abs(coefficient[0]) != 1) {
                b.append(Math.abs(coefficient[0]));
            }
            b.append("x^").append(n);
        }

        for (int i = 1; i <= n - 2; i++) {
            if (coefficient[i] == 0) {
                continue;
            }

            if (coefficient[i] > 0) {
                if(b.length() != 0){
                    b.append("+");
                }
            } else {
                b.append("-");
            }
            if (Math.abs(coefficient[i]) != 1) {
                b.append(Math.abs(coefficient[i]));
            }

            b.append("x^").append(n - i);
        }
        if (n >= 1 && coefficient[n - 1] != 0) {
            if (n >= 2) {
                if (coefficient[n - 1] > 0) {
                    if(b.length() != 0){
                        b.append("+");
                    }
                } else {
                    b.append("-");
                }
            }

            if (Math.abs(coefficient[n - 1]) != 1) {
                b.append(Math.abs(coefficient[n - 1]));
            }
            b.append("x");
        }

        if (coefficient[n] != 0) {
            if (b.length() != 0 && coefficient[n] > 0) {
                b.append("+");
            }
            b.append(coefficient[n]);
        }
        fastWriter.print(b.toString());
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
