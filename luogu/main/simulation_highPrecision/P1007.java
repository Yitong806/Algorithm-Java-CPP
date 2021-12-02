package luogu.main.simulation_highPrecision;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1007 {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);
        int n = fastReader.nextInt(), m = fastReader.nextInt();
        int[][] matrix = init(n);

        for (int i = 0; i < m; i++) {
            int x = fastReader.nextInt();
            int y = fastReader.nextInt();
            int r = fastReader.nextInt();
            int z = fastReader.nextInt();
            rotate(matrix, x, y, r, z);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                fastWriter.print(matrix[i][j] + " ");
            }
            fastWriter.println();
        }

        fastReader.close();
        fastWriter.close();
    }

    private static int[][] init(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = i * n + j + 1;
            }
        }

        return matrix;
    }

    private static void rotate(int[][] matrix, int x, int y, int r, int z) {
        int[][] deepCloned = deepClone(matrix);
        int startX = x - 1 - r, endX = x - 1 + r;
        int startY = y - 1 - r, endY = y - 1 + r;

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                int dx = x - 1 - i, dy = y - 1 - j;
                int rotatedX, rotatedY;
                if (z == 1) {
                    rotatedX = x - 1 + dy;
                    rotatedY = y - 1 - dx;
                } else {
                    rotatedX = x - 1 - dy;
                    rotatedY = y - 1 + dx;
                }

                matrix[rotatedX][rotatedY] = deepCloned[i][j];
            }
        }

    }

    private static int[][] deepClone(int[][] origin) {
        int[][] dc = new int[origin.length][origin[0].length];
        for (int i = 0; i < origin.length; i++) {
            System.arraycopy(origin[i], 0, dc[i], 0, origin[0].length);
        }

        return dc;
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
