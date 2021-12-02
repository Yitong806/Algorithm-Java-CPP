package luogu.main.simulation_highPrecision;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1328 {
    private static final int[][] TABLE = {
            {0, -1, 1, 1, -1},
            {1, 0, -1, 1, -1},
            {-1, 1, 0, -1, 1},
            {-1, -1, 1, 0, 1},
            {1, 1, -1, -1, 0}
    };

    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        int n = fastReader.nextInt(), na = fastReader.nextInt(), nb = fastReader.nextInt();
        int[] aCycle = new int[na];
        int[] bCycle = new int[nb];
        for (int i = 0; i < na; i++) {
            aCycle[i] = fastReader.nextInt();
        }

        for (int i = 0; i < nb; i++) {
            bCycle[i] = fastReader.nextInt();
        }

        int winA = 0, winB = 0;
        int currentAIndex = 0, currentBIndex = 0;
        while (n > 0) {
            int a = aCycle[currentAIndex];
            int b = bCycle[currentBIndex];

            if(TABLE[a][b] > 0){
                winA += TABLE[a][b];
            }else if(TABLE[a][b] < 0){
                winB -= TABLE[a][b];
            }


            currentAIndex = (currentAIndex + 1) % aCycle.length;
            currentBIndex = (currentBIndex + 1) % bCycle.length;
            n--;
        }

        fastWriter.println(winA +" "+winB);
        fastReader.close();
        fastWriter.close();
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
