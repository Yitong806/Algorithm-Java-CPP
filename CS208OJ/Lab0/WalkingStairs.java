package CS208OJ.Lab0;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

public class WalkingStairs {
    public static void main(String[] args) {
        FastReader fastReader=new FastReader(System.in);
        FastWriter fastWriter=new FastWriter(System.out);

        int t= fastReader.nextInt();
        for (int i = 0; i < t; i++) {
            int n = fastReader.nextInt();
            int k = fastReader.nextInt();

            /*long[]f=new long[n];
            for (int j = 0; j < k; j++) {
                f[j]=1;
            }*/
            //fastWriter.println(Arrays.toString(f));

            /*for (int j = 0; j < n; j++) {
                for (int l = 0; l < k; l++) {
                    try {
                        f[j] += f[j - l - 1];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }
                }
                f[j] %= 998244353;
            }
*/

            /*fastWriter.println(f[n-1]);*/
            fastWriter.println("True:" + getAnotherAnswer(n, k));
        }

        fastReader.close();
        fastWriter.close();
    }
    private static long getAnotherAnswer(int n,int k){
        long[]f=new long[n+1];
        f[0]=1;
        f[1]=1;
        for (int i = 2; i <= n; i++) {
            if(i<=k){
                f[i]=(f[i-1]*2)%998244353;
            }else {
                f[i]=(f[i-1]*2-f[i-k-1]+998244353)%998244353;
            }
        }
        return f[n]%998244353;
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
