import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1303 {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);
        String s1 = fastReader.next();
        boolean n1 = s1.charAt(0) == '-';
        if(n1){
            s1 = s1.substring(1);
        }

        String s2 = fastReader.next();

        boolean n2 = s2.charAt(0) == '-';
        if(n2){
            s2 = s2.substring(1);
        }

        String result = multiply(s1,s2);

        if(!result.equals("0") && (n1 ^ n2)){
            fastWriter.print("-");
        }

        fastWriter.println(result);
        fastReader.close();
        fastWriter.close();
    }

    private static String multiply(String s1, String s2) {
        int[] r1 = transform(s1), r2 = transform(s2);
        int[] result = new int[r1.length + r2.length];

        for (int i = r1.length - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = r2.length - 1; j >= 0||carry!=0; j--) {
                int index = i + j + 1;
                int number =carry +result[index];
                if(j >= 0){
                    number += r1[i] * r2[j];
                }
                carry = number / 10;
                number = number % 10;
                result[index] = number;
            }
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
