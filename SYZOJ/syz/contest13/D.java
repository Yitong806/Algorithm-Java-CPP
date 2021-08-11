package syz.contest13;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        long a = fastReader.nextLong();
        long b = fastReader.nextLong();

        for (long i = a; i <= b && i < 9989900; i++) {
            if(isSymmetric(i)&&isPrime(i)){
                fastWriter.println(i);
            }
        }

        fastReader.close();
        fastWriter.close();
    }
    private static boolean isSymmetric(long x){
        return Long.parseLong(new StringBuilder().append(x).reverse().toString())==x;
    }

    private static boolean isPrime(long x){
        if(x==0||x==1){
            return false;
        }

        if(x==2){
            return true;
        }

        if(x%2==0){
            return false;
        }

        for (int i = 3, upper = (int) Math.sqrt(x); i <= upper; i++) {
            if(x%i==0){
                return false;
            }
        }

        return true;
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
