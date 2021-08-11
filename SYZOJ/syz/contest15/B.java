package syz.contest15;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        int n = fastReader.nextInt();
        Player[] ps = new Player[n];
        for (int i = 0; i < n; i++) {
            String name = fastReader.next();
            int score = fastReader.nextInt();
            ps[i] = new Player(i,name,score);
        }

        Arrays.sort(ps);

        for (int i = 0; i < n; i++) {
            fastWriter.println(ps[i]);
        }

        fastReader.close();
        fastWriter.close();
    }
    private static class Player implements Comparable<Player>{
        private final int index;
        private final String name;
        private final int score;

        public Player(int index,String n, int s){
            this.index = index;
            this.name = n;
            this.score = s;
        }

        private String rank(){
            if(score==0){
                return "Bad";
            }else if(score<200){
                return "Not good";
            }else if(score<300){
                return "Bronze medal";
            }else if(score<400){
                return "Silver medal";
            }else {
                return "Gold medal";
            }
        }

        @Override
        public String toString() {
            return this.name+" "+this.score+" "+this.rank();
        }


        @Override
        public int compareTo(Player o) {
            if(this.score!=o.score){
                return Integer.compare(o.score,this.score);
            }else {
                return Integer.compare(this.index,o.index);
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
            writer.close();
        }
    }
}
