package syz.problems;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SYZ0024 {
    public static void main(String[] args) {
        FastReader fastReader=new FastReader(System.in);
        FastWriter fastWriter=new FastWriter(System.out);

        int n= fastReader.nextInt();
        int c= fastReader.nextInt();
        int[]array=new int[315];

        for (int i = 1; i <= n; i++) {
            array[i]= fastReader.nextInt();
        }

        fastWriter.println(getAnswer(array,n,c));

        fastReader.close();
        fastWriter.close();
    }
    private static int getAnswer(int[]array,int n,int c) {
        int[][] dp = new int[315][315];
        for (int i = 0; i < 315; i++) {
            Arrays.fill(dp[i],1234567890);
        }

        for (int i = 1; i <= n; i++) {
            dp[1][i]=0;
        }

        for (int i = 1; i <= c; i++) {
            for (int j = i; j <= n - c + i; j++) {
                for (int k = i - 1; k <= j - 1; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(array[k] - array[j]));
                }
            }
        }

        //System.out.println(Arrays.deepToString(dp));
        int answer = Integer.MAX_VALUE;

        for (int i = c; i <= n; i++) {
            //System.out.println(dp[c][i]);
            answer = Math.min(dp[c][i], answer);
        }

        return answer;
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
