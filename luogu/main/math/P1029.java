package luogu.main.math;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1029 {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        long x0 = fastReader.nextLong();
        long y0 = fastReader.nextLong();

        fastWriter.println(getAnswer(x0,y0));

        fastReader.close();
        fastWriter.close();
    }
    private static long getAnswer(long x0,long y0){
        long answer = 0;

        long start = Math.min(x0,y0);
        long end = Math.max(x0,y0);
        for (long p = start; p <= end; p++) {
            if((x0*y0)%p!=0){
                continue;
            }

            long q = (x0*y0)/p;

            if(p%start==0 && q%start==0 && end%p==0 && end%q==0 && isGCD(p,q,x0)){
                answer++;
            }
        }

        return answer;
    }

    private static boolean isGCD(long p, long q, long x0){
        long big = Math.max(p,q);
        long small = Math.min(p,q);

        while (big%small!=0){
            long t = big;
            big = small;
            small = t % small;
        }

        return x0 == small;
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
