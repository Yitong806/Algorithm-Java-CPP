<<<<<<< HEAD:luogu/main/simulation_highPrecision/P1017.java
package luogu.main.simulation_highPrecision;
=======
package luogu.main.math;
>>>>>>> ef495ec5ffc5b2e0c7600edae059e8b8b1644517:luogu/main/P1017.java

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1017 {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        int num10 = fastReader.nextInt();

        int R = fastReader.nextInt();

        fastWriter.println(answer(num10,R));

        fastReader.close();
        fastWriter.close();
    }
    private static String answer(int num10,int R){
        //R = Math.abs(R);
        int v = num10;

        StringBuilder answerBuilder = new StringBuilder();

        while (num10!=0){
            int nu = num10 % R;
            num10 /= R;

            if(nu<0){
                nu += Math.abs(R);
                num10++;
            }
            answerBuilder.append(nu<10?nu:String.valueOf((char) ('A'+nu-10)));
        }
        answerBuilder.reverse();

        return v + "=" +
                answerBuilder + "(base" + R + ")";
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
