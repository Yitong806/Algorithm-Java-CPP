package CS208OJ.Lab8;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class EncodingStrings {
    public static void main(String[] args) {
        FastReader fastReader=new FastReader(System.in);
        FastWriter fastWriter=new FastWriter(System.out);
        int n= fastReader.nextInt();

        while (n-->0){
            char[]cs=fastReader.next().toCharArray();
            HashMap<Character,Integer>frequencyMap=new HashMap<>();
            for (char c:cs){
                if(frequencyMap.containsKey(c)){
                    int fre=frequencyMap.get(c);
                    frequencyMap.put(c,fre+1);
                }else {
                    frequencyMap.put(c,1);
                }
            }

            PriorityQueue<CodingNode>codingPQ=new PriorityQueue<>(Comparator.comparingLong(c->c.sum));
            HashMap<Character, CodingNode>codingMap=new HashMap<>();
            for(char c:frequencyMap.keySet()){
                CodingNode node= new CodingNode(c,frequencyMap.get(c));
                codingPQ.offer(node);
                codingMap.put(c,node);
            }

            if(codingPQ.size()==1){
                fastWriter.println(cs.length);
                continue;
            }

            while (codingPQ.size()>1){
                CodingNode first= codingPQ.poll();
                CodingNode second= codingPQ.poll();

                CodingNode sum=new CodingNode(first.sum+second.sum);
                sum.leftChild=first;
                sum.rightChild=second;

                codingPQ.offer(sum);
            }

            CodingNode root= codingPQ.poll();
            HashSet<CodingNode>leaves=new HashSet<>();
            dfsSetLength(root,0,leaves);
            fastWriter.println(getCodingLength(cs,codingMap));
        }

        fastReader.close();
        fastWriter.close();
    }
    private static long getCodingLength(char[]cs,HashMap<Character, CodingNode>codingMap){
        long sum=0;
        for (char c:cs){
            sum+=codingMap.get(c).height;
        }

        return sum;
    }

    private static void dfsSetLength(CodingNode root,long curHeight,HashSet<CodingNode>leaves){
        if(root.isLeaf()){
            root.height=curHeight;
            leaves.add(root);
        }else {
            dfsSetLength(root.leftChild, curHeight+1, leaves);
            dfsSetLength(root.rightChild, curHeight+1, leaves);
        }
    }

    private static class CodingNode{
        char value='\0';
        long sum;
        CodingNode leftChild;
        CodingNode rightChild;
        long height;

        public CodingNode(char c,long s){
            this.value=c;
            this.sum=s;
        }

        public CodingNode(long s){
            this.sum=s;
        }

        public boolean isLeaf(){
            return this.value!='\0';
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
