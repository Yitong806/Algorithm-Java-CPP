package syz.problems;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SYZ0027 {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        int n = fastReader.nextInt();
        int v = fastReader.nextInt();
        int m = fastReader.nextInt();

        Book[] books = new Book[n];
        for (int i = 0; i < n; i++) {
            int volume = fastReader.nextInt();
            int weight = fastReader.nextInt();
            books[i] = new Book(volume,weight);
        }
        fastWriter.println(getAnswer(n,v,m,books));

        fastReader.close();
        fastWriter.close();
    }
    private static int getAnswer(int n,int v,int m,Book[]books){
        int[][] dpArray = new int[v+1][m+1];
        for (int i = 0; i < n; i++) {
            for (int j = v; j >= books[i].volume; j--){
                for (int k = m; k >= books[i].weight; k--) {
                    dpArray[j][k] = Math.max(dpArray[j][k],dpArray[j-books[i].volume][k-books[i].weight]+1);
                }
            }
        }

        return dpArray[v][m];
    }

    private static class Book{
        int volume;
        int weight;

        public Book(int volume,int weight){
            this.volume= volume;
            this.weight=weight;
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
            writer.close();
        }
    }
}
