<<<<<<< HEAD:luogu/main/simulation_highPrecision/P1011.java
package luogu.main.simulation_highPrecision;
=======
package luogu.main.math;
>>>>>>> ef495ec5ffc5b2e0c7600edae059e8b8b1644517:luogu/main/P1011.java

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1011 {
    private static final XNumber[] UP = new XNumber[30];
    private static final XNumber[] DOWN =new XNumber[30];
    private static final XNumber[] SIZE = new XNumber[30];

    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        long a = fastReader.nextLong();
        long n = fastReader.nextLong();
        long m = fastReader.nextLong();
        long x = fastReader.nextLong();

        build(a,n);

        fastWriter.println(getAnswer(a,n,m,x));

        fastReader.close();
        fastWriter.close();
    }
    private static long getAnswer(long a,long n,long m,long x){
        if(x==1||x==2){
            return a;
        }

        XNumber lastStation = SIZE[(int)n-1];

        long unknown = (m-lastStation.constant)/lastStation.xCoefficients;

        XNumber expectedStation = SIZE[(int)x];
        return expectedStation.xCoefficients*unknown+expectedStation.constant;
    }

    private static void build(long a,long n){
        UP[0] = new XNumber(0,0);
        UP[1] = new XNumber(0,a);
        UP[2] = new XNumber(1,0);

        DOWN[0] = new XNumber(0,0);
        DOWN[1] = new XNumber(0,0);
        DOWN[2] = new XNumber(1,0);

        SIZE[0] = new XNumber(0,0);
        SIZE[1] = new XNumber(0,a);
        SIZE[2] = new XNumber(0,a);

        for (int i = 3; i < 30; i++) {
            UP[i] = UP[i-1].add(UP[i-2]);
            DOWN[i] = UP[i-1];

            XNumber delta = new XNumber(UP[i].xCoefficients-DOWN[i].xCoefficients,UP[i].constant-DOWN[i].constant);
            SIZE[i] = SIZE[i-1].add(delta);
        }
    }

    private static class XNumber{
        private final long xCoefficients;
        private final long constant;

        public XNumber(long co,long cst){
            this.xCoefficients = co;
            this.constant = cst;
        }

        public XNumber add(XNumber ax){
            return new XNumber(this.xCoefficients+ax.xCoefficients, this.constant+ ax.constant);
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
