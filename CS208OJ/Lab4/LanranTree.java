package CS208OJ.Lab4;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LanranTree {
    private static final int maxSize=200000+10;
    private static final int[] values=new int[maxSize];
    private static final long[]f=new long[maxSize];
    private static final long[]s=new long[maxSize];
    private static final ArrayList<Integer>[] edge =new ArrayList[maxSize];
    private static long maxAnswer=0;
    static {
        for (int i = 0; i < maxSize; i++) {
            edge[i]=new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        FastReader fastReader=new FastReader(System.in);
        FastWriter fastWriter=new FastWriter(System.out);

        int n= fastReader.nextInt();
        for (int i = 1; i <= n; i++) {
            values[i]= fastReader.nextInt();
        }

        for (int i = 0; i < n-1; i++) {
            int x= fastReader.nextInt();
            int y= fastReader.nextInt();
            edge[x].add(y);
            edge[y].add(x);
        }

        fastWriter.println(getMaxAnswer());

        fastReader.close();
        fastWriter.close();
    }
    private static long getMaxAnswer(){
        dfs(1,0);
        dfs(1,0,0,0);
        return maxAnswer;
    }

    private static void dfs(int u,int fa){
        s[u]=values[u];
        f[u]=0;
        for (int i = 0; i < edge[u].size(); i++) {
            int v=edge[u].get(i);
            if(v!=fa){
                dfs(v,u);
                f[u]+=f[v]+s[v];
                s[u]+=s[v];
            }
        }
    }

    private static void dfs(int u,int fa,long updates,long updatef){
        maxAnswer=Math.max(maxAnswer,f[u]+updatef);
        for (int i = 0; i < edge[u].size(); i++) {
            int v=edge[u].get(i);
            if(v!=fa){
                long ups=updates+s[u]-s[v];
                dfs(v,u,ups,updatef+f[u]-f[v]-s[v]+ups);
            }
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
