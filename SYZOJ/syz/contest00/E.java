package syz.contest00;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class E {
    private static boolean[] isPrime = new boolean[(int) 2e6+10];
    private static int[] primeSize = new int[(int) 2e6 +10];

    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        build();

        int n = fastReader.nextInt();
        int q = fastReader.nextInt();

        for (int i = 0; i < q; i++) {
            int l = 1;
            int r = 2000000;

            int primeCount = primeSize[r]-primeSize[l-1];

            fastWriter.println(primeCount);
        }

        fastReader.close();
        fastWriter.close();

    }
    private static void build(){
        primeSize[0] = 0;
        primeSize[1] = 0;
        primeSize[2] = 1;

        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = judgeIsPrime(i);
            if(i!=0){
                if(isPrime[i]){
                    primeSize[i] = primeSize[i-1]+1;
                }else {
                    primeSize[i] = primeSize[i-1];
                }
            }

        }
    }

    private static boolean judgeIsPrime(int v){
        if(v==0||v==1){
            return false;
        }
        if(v==2){
            return true;
        }

        if(v%2==0){
            return false;
        }

        for (int i = 3 , upper = (int)Math.sqrt(v); i <= upper; i+=2) {
            if(v%i==0){
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
