package CS208OJ.Lab6;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TrafficLight {
    private static final int MAX_SIZE_EDGE = 100005;
    private static final int MAX_SIZE_NODE = 10005;
    private static final StreamTokenizer in =
        new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static final FastWriter out = new FastWriter(System.out);
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

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        Node[] nodes = new Node[n];
        Edge[] edges = new Edge[m];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < m; i++) {
            int from = nextInt();
            int to = nextInt();
            long wi = nextLong();

            Edge e = new Edge(nodes[from - 1], nodes[to - 1], wi);
            edges[i] = e;
            nodes[from - 1].outNeighborEdges.add(e);
        }

        for (int i = 0; i < n; i++) {
            long ai = nextLong();
            long bi = nextLong();
            nodes[i].setTraffic(ai, bi);
        }

        long shortest = getShortestTime(nodes[0], nodes[n - 1], edges, nodes);
        out.println(shortest);

        out.close();
    }

    public static long getShortestTime(Node root, Node dst, Edge[] edges, Node[] nodes) {
        PriorityQueue<Edge> heap = new PriorityQueue<>((o1, o2) -> o1.time < o2.time ? -1 : 1);

        Node temp = root;
        temp.hasVisited = true;

        long time = 0;
        while (!temp.equals(dst)) {
            heap.addAll(temp.setAllEdges(time));
            Edge e = heap.poll();
            temp = e.toNode;
            while (temp.hasVisited) {
                e = heap.poll();
                temp = e.toNode;
            }

            temp.hasVisited = true;
            time = e.time;
        }

        return time;
    }

    private static class Node {
        int index;
        ArrayList<Edge> outNeighborEdges;
        long ai, bi;
        long arrive;
        boolean hasVisited;

        public Node(int index) {
            this.hasVisited = false;
            this.outNeighborEdges = new ArrayList<>();
            this.index = index;
            this.arrive = 0;
            this.ai = this.bi = 0;
        }

        public void setTraffic(long ai, long bi) {
            this.ai = ai;
            this.bi = bi;
        }

        public long ab() {
            return ai + bi;
        }

        public ArrayList<Edge> setAllEdges(long t) {
            for (Edge e : outNeighborEdges) {
                e.resetTime(t);
            }
            return this.outNeighborEdges;
        }
    }

    private static class Edge {
        Node fromNode;
        Node toNode;
        long wi;
        long time;

        public Edge(Node from, Node to, long wi) {
            this.fromNode = from;
            this.toNode = to;
            this.wi = wi;
        }

        public void resetTime(long time) {
            long t = (time + wi) % toNode.ab();
            if (toNode.bi == 0) {
                time = Integer.MAX_VALUE;
            } else if (t >= toNode.ai) {
                t = 0;
            } else {
                t = toNode.ai - t;
            }

            this.time = time + t + wi;
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
