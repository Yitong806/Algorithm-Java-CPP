package luogu.cf.cf1;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Locale;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        int n = fastReader.nextInt();
        for (int i = 0; i < n; i++) {
            String ins = fastReader.next();

            if(isRXCY(ins)){
                fastWriter.println(RXCY2AB12(ins));
            }else {
                fastWriter.println(AB122RXCY(ins));
            }
        }

        fastReader.close();
        fastWriter.close();
    }
    private static boolean isRXCY(String ins){
        boolean hasR = false;
        boolean hasC = false;
        boolean R123 = false;
        boolean C123 = false;

        char[] cs = ins.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if(cs[i] == 'C'){
                hasC = true;
                if(i+1<cs.length && Character.isDigit(cs[i+1])){
                    C123 = true;
                }

            }else if(cs[i]=='R'){
                hasR = true;

                if(i+1 < cs.length && Character.isDigit(cs[i+1])){
                    R123 = true;
                }
            }
        }

        return hasC && hasR && C123 && R123;
    }

    private static String RXCY2AB12(String rc){
        int rIndex = rc.indexOf('R');
        int cIndex = rc.indexOf('C');

        String rString = rc.substring(rIndex+1,cIndex);
        String cString = rc.substring(cIndex+1);

        int r = Integer.parseInt(rString);
        int c = Integer.parseInt(cString);

        String abc = Integer.toString(c,26);
        //System.out.println(abc);

        StringBuilder ab12Builder = new StringBuilder();

        StringBuilder afterBuilder = new StringBuilder();

        char[] cs = new StringBuilder(abc).reverse().toString().toUpperCase(Locale.ROOT).toCharArray();

        int brought = 0;

        for (int i = 0; i < cs.length; i++) {
            char ca = cs[i];
            if(Character.isDigit(ca)){
                if(ca - '0'+ 'A' - 1 - brought < 'A'){
                    if(i!=cs.length-1){
                        afterBuilder.append((char) (ca - '0' + 'A' - 1  - brought + 26));
                    }
                    brought = 1;
                }else {
                    afterBuilder.append((char) (ca - '0' + 'A' - 1 - brought));
                    brought = 0;
                }

            }else{
                afterBuilder.append((char)(ca - 'A' + 'J' - brought));
                brought = 0;
            }
        }

        ab12Builder.append(afterBuilder.reverse());

        return ab12Builder.append(r).toString();
    }

    private static String AB122RXCY(String ab){
        int index = 0;

        for (int i = 0; i < ab.length(); i++) {
            if(Character.isDigit(ab.charAt(i))){
                index = i;
                break;
            }
        }

        String before = ab.substring(0,index);
        String after = ab.substring(index);

        StringBuilder rxcyBuilder = new StringBuilder();
        rxcyBuilder.append("R").append(after).append("C");

        long beforeNumber = 0;
        for (int i = before.length()-1, pow26 = 0; i>= 0;i--, pow26++){
            int n = before.charAt(i) - 'A' + 1;
            beforeNumber += n * (long)Math.pow(26, pow26);
        }

        rxcyBuilder.append(beforeNumber);

        return rxcyBuilder.toString();
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
