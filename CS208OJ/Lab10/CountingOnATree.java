package CS208OJ.Lab10;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CountingOnATree {
    private static final StreamTokenizer in =
            new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static final FastWriter fastWriter = new FastWriter(System.out);

    private static int nextInt() {
        try {
            in.nextToken();
            return (int) in.nval;
        } catch (IOException e) {
            return -1;
        }
    }
    private static long nextLong() {
        try {
            in.nextToken();
            return (long) in.nval;
        } catch (IOException e) {
            return -1;
        }
    }
    private static final PriorityQueue<Node> pq =
            new PriorityQueue<>(Comparator.comparingLong(n -> n.length));
    private static final long[] father = new long[200010];
    private static final long[] answer = new long[200010];
    private static final long[] numbers = new long[200010];

    public static void main(String[] args) {
        long n = nextInt();
        long m = nextInt();
        for (int i = 0; i < n - 1; i++) {
            pq.offer(new Node(nextInt(), nextInt(), nextLong()));
        }

        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            if (father[poll.to_a] == poll.to_a && father[poll.to_b] == poll.to_b && numbers[poll.to_a] == 0
                    && numbers[poll.to_b] == 0) {
                father[poll.to_b] = poll.to_a;
                numbers[poll.to_a] += 2;
                answer[(int) poll.length] += 1;
            } else {
                if (numbers[poll.to_a] == 0 && father[poll.to_a] == poll.to_a) {
                    numbers[poll.to_a]++;
                    father[poll.to_a] = getFather(poll.to_b);
                    answer[(int) (poll.length)] += numbers[(int) father[poll.to_b]];
                    numbers[(int) (father[poll.to_b])] += numbers[poll.to_a];
                } else if (numbers[poll.to_b] == 0 && father[poll.to_b] == poll.to_b) {
                    numbers[poll.to_b]++;
                    father[poll.to_b] = getFather(poll.to_a);
                    answer[(int) (poll.length)] += numbers[(int) father[poll.to_a]];
                    numbers[(int) (father[poll.to_a])] += numbers[poll.to_b];
                } else {
                    answer[(int) (poll.length)] +=
                            (numbers[(int) getFather(poll.to_a)]) * (numbers[(int) getFather(poll.to_b)]);
                    numbers[(int) (getFather(poll.to_a))] += numbers[(int) (getFather(poll.to_b))];
                    father[(int) (getFather(poll.to_b))] = getFather(poll.to_a);
                }
            }
        }

        for (int i = 0; i < 200010 - 1; i++) {
            answer[i + 1] += answer[i];
        }

        for (int i = 0; i < m; i++) {
            int ask = nextInt();
            fastWriter.print(answer[ask]);
            fastWriter.print(' ');
        }

        fastWriter.close();
    }
    private static class Node {
        int to_a;
        int to_b;
        long length;

        public Node(int to_a, int to_b, long length) {
            this.to_a = to_a;
            this.to_b = to_b;
            this.length = length;
        }
    }
    private static long getFather(long a) {
        if (father[(int) a] == a) {
            return a;
        } else {
            return father[(int) a] = getFather(father[(int) a]);
        }
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
                if (s == null)
                    return false;
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
            writer.flush();
            writer.close();
        }
    }
}