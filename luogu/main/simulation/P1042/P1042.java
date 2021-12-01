package luogu.main.simulation;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1042 {
    private static final FastReader fastReader = new FastReader(System.in);
    private static final FastWriter fastWriter = new FastWriter(System.out);

    public static void main(String[] args) {
        String plays = readString();
        process(plays,11);
        process(plays,21);
        fastReader.close();
        fastWriter.close();
    }

    private static String readString(){
        StringBuilder b = new StringBuilder();
        while (true){
            String s = fastReader.nextLine();
            if(s == null){
                return b.toString();
            }
            for (char c: s.toCharArray()){
                if(c == 'E'){
                    return b.toString();
                }
                b.append(c);
            }
        }
    }

    private static void process(String plays, int cnt){
        int mine = 0;
        int opponent = 0;

        char[] cs = plays.toCharArray();
        int index = 0;
        boolean printed = false;
        while (index < cs.length){
            while ((mine < cnt && opponent < cnt) || Math.abs(mine - opponent) < 2){
                if(cs[index] == 'W'){
                    mine++;

                }else {
                    opponent++;
                }
                index++;

                if(index == cs.length){
                    break;
                }
            }
            printed = true;
            fastWriter.println(mine+":"+opponent);
            if(index == cs.length){
                break;
            }
            mine = opponent = 0;
        }

        if(!((mine < cnt && opponent < cnt) || Math.abs(mine - opponent) < 2) || !printed){
            fastWriter.println("0:0");
        }


        fastWriter.println();

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
