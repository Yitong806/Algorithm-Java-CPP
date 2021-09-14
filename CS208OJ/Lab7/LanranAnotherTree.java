package CS208OJ.Lab7;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class LanranAnotherTree {
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static final FastWriter fastWriter=new FastWriter(System.out);
    private static final HashSet<Long>fibonacciSet=new HashSet<>();

    private static int nextInt(){
        try{
            in.nextToken();
            return (int)in.nval;
        }catch (IOException e){
            return -1;
        }
    }
    public static void main(String[] args) {
        int t= nextInt();

        long[]fibonacciSum=getFibonacciSum();
        while (t-->0){
            int n= nextInt();
            int m= nextInt();
            Node[]nodes=new Node[n+1];
            Edge[]edges=new Edge[m];
            for (int i = 0; i <= n; i++) {
                nodes[i]=new Node(i);
            }
            for (int i = 0; i < m; i++) {
                int u= nextInt();
                int v= nextInt();
                int w= nextInt();
                edges[i]=new Edge(nodes[u],nodes[v],w);
            }

            int minSpanningTree=kruskal(nodes,edges,Comparator.comparingInt(e->e.weight),n,m);
            rollback(nodes);
            int maxSpanningTree=kruskal(nodes,edges,Comparator.comparingInt(e->e.weight*-1),n,m);
            if(minSpanningTree==-1||maxSpanningTree==-1){
                fastWriter.println("No");
                continue;
            }

            if(minSpanningTree==maxSpanningTree){
                fastWriter.println(fibonacciSet.contains((long)minSpanningTree)?"Yes":"No");
            }else {
                fastWriter.println(fibonacciSum[minSpanningTree]!=fibonacciSum[maxSpanningTree]?"Yes":"No");
            }

        }
        fastWriter.close();
    }
    private static void rollback(Node[]nodes){
        for (Node n:nodes){
            n.father=n;
        }
    }

    private static int kruskal(Node[]nodes,Edge[]edges,Comparator<Edge>edgeComparator,int n,int m){
        Arrays.sort(edges,edgeComparator);
        int answer=0,countt=1;
        for (Edge edge : edges) {
            Node t1 = edge.from.getFather();
            Node t2 = edge.to.getFather();
            if (t1 != t2) {
                answer += edge.weight;
                t2.father = t1.father;
                countt++;
                if (countt == n) {
                    break;
                }
            }
        }

        return countt== n?answer:-1;
    }

    private static long[] getFibonacciSum(){
        long[]fibonacciCount=new long[100005];
        int index1=1;
        int index2=1;
        while (true){
            try{
                fibonacciSet.add((long)index1);
                fibonacciSet.add((long)index2);
                fibonacciCount[index1]++;
                fibonacciCount[index2]++;
                int temp=index1;
                index1=index2;
                index2+=temp;
            }catch (ArrayIndexOutOfBoundsException e){
                break;
            }
        }

        long[]fibonacciSum=new long[100005];
        for (int i = 0; i < 100005; i++) {
            if(i==0){
                fibonacciSum[i]=fibonacciCount[i];
            }else {
                fibonacciSum[i]=fibonacciSum[i-1]+fibonacciCount[i];
            }
        }

        return fibonacciSum;
    }

    private static class Node{
        Node father;
        int index;
        public Node(int index){
            this.index=index;
            this.father=this;
        }
        public Node getFather(){
            if(this==this.father){
                return this;
            }else {
                return this.father=this.father.getFather();
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    '}';
        }
    }
    private static class Edge{
        Node from;
        Node to;
        int weight;
        public Edge(Node n1,Node n2,int w){
            this.from =n1;
            this.to =n2;
            this.weight=w;
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
