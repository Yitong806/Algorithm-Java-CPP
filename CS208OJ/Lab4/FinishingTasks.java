package CS208OJ.Lab4;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class FinishingTasks {
    public static void main(String[] args) {
        FastReader fastReader=new FastReader(System.in);
        FastWriter fastWriter=new FastWriter(System.out);

        int n= fastReader.nextInt();
        int m= fastReader.nextInt();

        Node[]nodes=new Node[n+1];
        for (int i = 1; i <= n; i++) {
            nodes[i]=new Node();
            nodes[i].index=i;
        }

        for (int i = 0; i < m; i++) {
            int x1= fastReader.nextInt();
            int x2= fastReader.nextInt();
            nodes[x1].neighbors.add(nodes[x2]);
            nodes[x2].incomingCount++;
        }

        Queue<Node>resultList=new LinkedList<>();
        PriorityQueue<Node>nodeSet=new PriorityQueue<>((o1, o2) -> {
            if(o1.incomingCount!=o2.incomingCount){
                return o1.incomingCount-o2.incomingCount;
            }else {
                return o1.index-o2.index;
            }
        });

        for (int i = 1; i <= n; i++) {
            if(nodes[i].incomingCount==0){
                nodeSet.offer(nodes[i]);
            }
        }

        while (!nodeSet.isEmpty()){
            Node nodeN= nodeSet.poll();
            resultList.offer(nodeN);
            for (int i = 0; i < nodeN.neighbors.size(); i++) {
                nodeN.neighbors.get(i).incomingCount--;
                if(nodeN.neighbors.get(i).incomingCount==0){
                    nodeSet.offer(nodeN.neighbors.get(i));
                }
            }
        }

        if(resultList.size()!=n){
            fastWriter.println("Impossible");
        }else {
            while (!resultList.isEmpty()){
                fastWriter.print(resultList.poll()+" ");
            }
        }

        fastReader.close();
        fastWriter.close();
    }
    private static class Node{
        int index=0;
        ArrayList<Node>neighbors=new ArrayList<>();
        int incomingCount=0;

        @Override
        public String toString() {
            return String.valueOf(index);
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
