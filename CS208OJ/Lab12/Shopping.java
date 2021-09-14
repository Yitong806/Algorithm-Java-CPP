package CS208OJ.Lab12;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Shopping {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        int n = fastReader.nextInt();
        int m = fastReader.nextInt();

        int[] wis = new int[n+1];
        int[] cis = new int[n+1];

        for (int i = 1; i <= n; i++) {
            wis[i] = fastReader.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            cis[i] = fastReader.nextInt();
        }

        fastWriter.println(knapsack(n,m,wis,cis));

        fastReader.close();
        fastWriter.close();
    }
    private static int knapsack(int n,int w,int[]wis,int[]vis){
        int[][]M=new int[n+1][w+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                M[i][j]=M[i-1][j];
                if(j>=vis[i]){
                    M[i][j]=Math.max(M[i][j],M[i-1][j-vis[i]]+wis[i]);
                }
            }
        }
        return M[n][w];
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
