package CS208OJ.Lab12;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class SlimeOnLanrand {
    private static final StreamTokenizer in
            =new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static final FastWriter fastWriter=new FastWriter(System.out);

    private static int nextInt(){
        try{
            in.nextToken();
            return (int)in.nval;
        }catch (IOException e){
            return -1;
        }
    }
    private static long nextLong(){
        try{
            in.nextToken();
            return (long)in.nval;
        }catch (IOException e){
            return -1;
        }
    }


    public static void main(String[] args) {
        int n=nextInt();
        int[] data=new int[n];
        for (int i = 0; i < n; i++) {
            data[i]=nextInt();
        }

        fastWriter.println(slimeGame(data));

        fastWriter.close();
    }
    private static int slimeGame(int[] A) {
        int size = A.length;

        int[][] dp = new int[size][size];
        int[] sum_a = new int[size + 1];

        for (int i = 0; i < size; i++) {
            sum_a[i + 1] = sum_a[i] + A[i];
        }
        for (int len = 2; len <= size; len++) {
            for (int i = 0; i + len - 1 < size; i++) {
                int r = i + len - 1;
                dp[i][r] = 123456789;
                for (int j = i; j < r; j++){
                    dp[i][r] = Math.min(dp[i][r], dp[i][j] + dp[j + 1][r] + sum_a[r + 1] - sum_a[i]);
                }
            }
        }

        return dp[0][size-1];
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
