package CS208OJ.Lab5;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class PlayingAGame {
    private static final StreamTokenizer in=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static final FastWriter fastWriter=new FastWriter(System.out);
    private static long currentHP=0;
    private static long restTime=0;
    private static int nextInt(){
        try{
            in.nextToken();
            return (int)in.nval;
        }catch (IOException e){
            return 0;
        }
    }
    private static long nextLong(){
        try{
            in.nextToken();
            return (long)in.nval;
        }catch (IOException e){
            return 0;
        }
    }

    public static void main(String[] args) {

        int n= nextInt();
        Node[]nodes=new Node[n+1];
        for (int i = 1; i <= n; i++) {
            int ai= nextInt();
            nodes[i]=new Node(i,ai);
        }

        Edge[]edges=new Edge[n-1];
        for (int i = 0; i < n - 1; i++) {
            int n1= nextInt();
            int n2= nextInt();
            long w= nextLong();
            nodes[n1].neighbors.add(nodes[n2]);
            nodes[n2].neighbors.add(nodes[n1]);
            edges[i]=new Edge(nodes[n1],nodes[n2],w);
        }
        Arrays.sort(edges, (o1, o2) -> {
            if(o1.n1.index!=o2.n1.index){
                return o1.n1.index-o2.n1.index;
            }else {
                return o1.n2.index-o2.n2.index;
            }
        });
        dfsBuildTree(nodes[1]);
        setWeights(edges);
        dfsSetProfit(nodes[1]);
        getRestTime(nodes[1]);
        fastWriter.println(restTime);

        fastWriter.close();
    }
    private static void dfsBuildTree(Node root){
        int size = root.neighbors.size();
        for (int i = 0; i < size; i++) {
            Node v= root.neighbors.get(i);
            if(v!= root.father){
                root.children.add(v);
                v.father= root;
                dfsBuildTree(v);
            }
        }
    }

    private static void setWeights(Edge[]edges){
        for (Edge e : edges) {
            Node n1 = e.n1;
            Node n2 = e.n2;
            if (n1 == n2.father) {
                n2.requiredEffort = e.wi;
            } else if (n2 == n1.father) {
                n1.requiredEffort = e.wi;
            }
        }
    }

    private static void dfsSetProfit(Node root){
        root.profit=root.food- root.requiredEffort*2;

        for (Node child: root.children){
            dfsSetProfit(child);
            root.profit+= child.profit;
        }
    }

    private static void getRestTime(Node root){
        if(currentHP< root.requiredEffort){
            restTime+= root.requiredEffort-currentHP;
            currentHP=0;
        }else {
            currentHP-=root.requiredEffort;
        }

        if(!root.visited){
            currentHP+=root.food;
            root.visited=true;
        }

        root.children.sort(Comparator.naturalOrder());
        for (Node child:root.children){
            getRestTime(child);
        }

        if(currentHP< root.requiredEffort){
            restTime+= root.requiredEffort-currentHP;
            currentHP=0;
        }else {
            currentHP-=root.requiredEffort;
        }

    }

    private static class Node implements Comparable<Node>{
        Node father;
        ArrayList<Node>children=new ArrayList<>();

        int index;
        long food;
        ArrayList<Node>neighbors;
        long requiredEffort;
        long profit;
        boolean visited;

        public Node(int i,long ai){
            this.index=i;
            this.food=ai;
            this.neighbors=new ArrayList<>();
            this.visited=false;
        }

        public int compareTo(Node o) {
            if(o.profit>=0&&this.profit>=0){
                return this.requiredEffort>o.requiredEffort?1:-1;
            }else {
                return o.profit>this.profit?1:-1;
            }
        }
    }

    private static class Edge{
        Node n1;
        Node n2;
        long wi;
        public Edge(Node n1,Node n2,long wi){
            this.n1=n1;
            this.n2=n2;
            this.wi=wi;
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
            while(!st.hasMoreTokens()) {
                String s = nextLine();
                if(s==null) return false;
                eat(s);
            }
            return true;
        }

        public String next() {
            hasNext();
            return st.nextToken();
        }

        public boolean nextBoolean(){
            return Boolean.parseBoolean(next());
        }


        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public float nextFloat(){
            return Float.parseFloat(next());
        }

        public double nextDouble(){
            return Double.parseDouble(next());
        }

        public BigInteger nextBigInteger(){
            return new BigInteger(next());
        }

        public BigDecimal nextBigDecimal(){
            return new BigDecimal(next());
        }

        public void close(){
            try{
                st=null;
                br.close();
            }catch (IOException e){
                e.printStackTrace();
                System.exit(1);
            }

        }
    }

    private static class FastWriter implements Closeable{
        private final PrintWriter writer;

        public FastWriter(OutputStream out){
            this.writer=new PrintWriter(out);
        }

        public void print(Object object){
            writer.write(object.toString());
        }

        public void printf(String format,Object... os){
            writer.write(String.format(format,os));
        }

        public void println(){
            writer.write(System.lineSeparator());
        }

        public void println(Object object){
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
