package CS208OJ.Lab5;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CriminalsProblem {
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static int readInt() throws IOException{
        in.nextToken();
        return (int)in.nval;
    }

    public static void main(String[] args) throws IOException {

        FastWriter fastWriter=new FastWriter(System.out);

        int n= readInt();
        int m= readInt();
        int k= readInt();
        int t= readInt();

        Criminal[]criminals=new Criminal[n];
        for (int i = 0; i < n; ++i) {
            int pos= readInt();
            criminals[i]=new Criminal(pos);
        }
        Arrays.sort(criminals);

        House[]houses=new House[m];
        for (int i = 0; i < m; ++i) {
            int pos= readInt();
            houses[i]=new House(k,pos);
        }
        Arrays.sort(houses);

        int houseIndex=0;
        int answer=0;
        for (int i = 0; i < n; ++i) {
            if(houseIndex>=m){
                break;
            }
            if(canBeHidden(criminals[i],houses[houseIndex],t)){
                criminals[i].hasEnteredHouse=true;
                answer++;
                ++houses[houseIndex].hasContained;
            }else {
                if(houses[houseIndex].position-criminals[i].position<=t){
                    ++houseIndex;
                    --i;
                }
            }
        }

        fastWriter.println(answer);

        fastWriter.close();
    }
    private static boolean canBeHidden(Criminal c,House h,int t){
        if(h.hasContained==h.capacity){
            return false;
        }
        return Math.abs(c.position-h.position)<=t;
    }

    private static class House implements Comparable<House>{
        int hasContained;
        int capacity;
        int position;
        public House(int c,int p){
            this.hasContained=0;
            this.capacity=c;
            this.position=p;
        }
        @Override
        public int compareTo(House o) {
            return this.position-o.position;
        }
    }

    private static class Criminal implements Comparable<Criminal>{
        int position;
        boolean hasEnteredHouse;
        public Criminal(int pos){
            this.position =pos;
            this.hasEnteredHouse=false;
        }

        @Override
        public int compareTo(Criminal o) {
            return this.position-o.position;
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


        public int readInt() {
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
