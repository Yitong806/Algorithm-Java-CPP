package CS208OJ.Lab11;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LanransAnotherInfiniteString {
    private static final FastReader in=new FastReader(System.in);
    private static final FastWriter out=new FastWriter(System.out);
    private static final long[]LRN=new long[3];

    public static void main(String[] args) {
        int n=in.nextInt();
        String sn=getLanranByBruteForce(7);
        //out.println(sn);


        for (int i = 0; i < n; i++) {
            long index= in.nextLong();
            setLRN(1,index);
            out.println(LRN[0]+" "+LRN[1]+" "+LRN[2]);
            Arrays.fill(LRN,0);
            //out.println(Arrays.toString(getLRN(sn, (int) index)));
        }

        in.close();
        out.close();
    }
    private static void setLRN(long start,long end){
        long pow=(long)(Math.log(end)/Math.log(2));
        long center=(long)(Math.pow(2,pow));
        if(start>end){
            return;
        }
        if(start==1 && end==1){
            LRN[0]+=1;
            LRN[1]+=0;
            LRN[2]+=0;
            return;
        }

        if(start==1&& end==2){
            LRN[0]+=1;
            LRN[1]+=1;
            LRN[2]+=0;
            return;
        }

        if(start==1 && end==center){
            long l=LRN[0];
            long r=LRN[1];
            long n=LRN[2];
            setLRN(1,end/2);
            long delta_l=LRN[0]-l;
            long delta_r=LRN[1]-r;
            long delta_n=LRN[2]-n;

            LRN[0]+=delta_n;
            LRN[1]+=delta_l;
            LRN[2]+=delta_r;
        }else {
            if(start==1){
                setLRN(1,center);
                setLRN(center+1,end);
            }else {
                long l=LRN[0];
                long r=LRN[1];
                long n=LRN[2];
                setLRN(start-center,end-center);
                long delta_l=LRN[0]-l;
                long delta_r=LRN[1]-r;
                long delta_n=LRN[2]-n;

                LRN[0]=delta_n+l;
                LRN[1]=delta_l+r;
                LRN[2]=delta_r+n;
            }

        }
    }

    private static int[] getLRN(String s,int index){
        int[]lrn=new int[3];
        char[]str=s.toCharArray();
        int counter=0;
        for (char c:str){

            if(counter>=index){
                break;
            }
            //System.out.print(c);
            counter++;
            switch (c){
                case 'L':{
                    lrn[0]++;
                    break;
                }

                case 'R':{
                    lrn[1]++;
                    break;
                }

                case 'N':{
                    lrn[2]++;
                    break;
                }
            }
        }
        //System.out.println();

        return lrn;
    }

    private static String getLanranByBruteForce(int n){
        if(n==1){
            return "LR";
        }
        String last=getLanranByBruteForce(n-1);
        return last+switchBruteForce(last);
    }
    private static String switchBruteForce(String s){
        StringBuilder b=new StringBuilder(s.length());
        char[]str=s.toCharArray();
        for (char c:str){
            switch (c){
                case 'L':{
                    b.append('R');
                    break;
                }
                case 'R':{
                    b.append('N');
                    break;
                }
                case 'N':{
                    b.append('L');
                    break;
                }
            }
        }

        return b.toString();
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
