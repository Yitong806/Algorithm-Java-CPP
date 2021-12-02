<<<<<<< HEAD:luogu/main/simulation_highPrecision/P1015.java
package luogu.main.simulation_highPrecision;
=======
package luogu.main.simulation;
>>>>>>> ef495ec5ffc5b2e0c7600edae059e8b8b1644517:luogu/main/P1015.java

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1015 {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        int N = fastReader.nextInt();
        String M = fastReader.next();

        long step = getSteps(N,M);

        fastWriter.println(step==-1?"Impossible!":"STEP="+step);

        fastReader.close();
        fastWriter.close();
    }
    private static long getSteps(int N,String M){
        if(isHuiWen(M,N)){
            return 0;
        }

        for (int i = 1; i <= 30; i++) {
            M = addReverse(N,M);
            if(isHuiWen(M,N)){
                return i;
            }
        }

        return -1;
    }

    private static String addReverse(int N,String M){
        BigInteger bi = new BigInteger(M,N);
        BigInteger re = new BigInteger(new StringBuilder(M).reverse().toString(),N);

        return bi.add(re).toString(N);
    }

    private static boolean isHuiWen(String number10, int N){
        BigInteger bi = new BigInteger(number10,N);

        return new StringBuilder().append(bi.toString(N)).reverse().toString().equals(bi.toString(N));
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
