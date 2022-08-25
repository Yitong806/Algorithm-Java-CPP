import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1601 {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        String s1 = fastReader.next();
        String s2 = fastReader.next();
        fastWriter.println(add(s1,s2));

        fastReader.close();
        fastWriter.close();
    }

    private static String add(String s1, String s2) {
        int length1 = s1.length(), length2 = s2.length();
        int maxLength = Math.max(length1, length2);

        s1 = add0(s1, maxLength);
        s2 = add0(s2, maxLength);
        int resultLength = maxLength + 1;

        int[] r1 = transform(s1), r2 = transform(s2);
        int[] result = new int[resultLength];

        int carry = 0;
        for (int i = resultLength - 1; i > 0 || carry != 0; i--) {
            int number = carry;
            if (i > 0) {
                number += r1[i - 1] + r2[i - 1];
            }
            carry = number / 10;
            number = number % 10;
            result[i] = number;
        }

        boolean no0 = false;
        StringBuilder b = new StringBuilder();
        for (int j : result) {
            if (j != 0) {
                no0 = true;
            }

            if (no0) {
                b.append(j);
            }
        }

        if(!no0){
            return "0";
        }

        return b.toString();
    }

    private static String add0(String s, int maxLength) {
        StringBuilder sBuilder = new StringBuilder(s);
        while (sBuilder.length() < maxLength) {
            sBuilder.insert(0, "0");
        }
        return sBuilder.toString();
    }

    private static int[] transform(String s) {
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = s.charAt(i) - '0';
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
