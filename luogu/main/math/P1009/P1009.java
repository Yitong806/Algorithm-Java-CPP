package luogu.main.math;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1009 {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);
        
        int n = fastReader.nextInt();

        fastWriter.println(calculate(n));

        fastReader.close();
        fastWriter.close();
    }
    private static String calculate(int n){
        String sum = "0";
        String pow = "1";

        for (int i = 1; i <= n; i++) {
            String nString = String.valueOf(i);

            pow = multiply(pow,nString);
            sum = add(sum,pow);
        }

        return sum;
    }
    
    private static String multiply(String s1,String s2){
        int maxLength = Math.max(s1.length(),s2.length());

        s1 = append0(s1,maxLength);
        s2 = append0(s2,maxLength);

        long[] num1 = change2Array(s1);
        long[] num2 = change2Array(s2);

        long[] result = new long[num1.length + num2.length];

        for (int i = num1.length - 1; i>= 0;i--){

            long carry = 0;
            for (int j = num2.length - 1; j >= 0||carry!=0; j--) {
                long number = carry + result[i + j + 1];

                if(j>=0){
                    number += num1[i]*num2[j];
                }

                carry = number/10;
                number %= 10;

                result[i + j + 1] = number;
            }
        }

        return change2String(result);
    }

    private static String add(String s1,String s2){
        int maxLength = Math.max(s1.length(),s2.length());

        s1 = append0(s1, maxLength);
        s2 = append0(s2, maxLength);

        long[] num1 = change2Array(s1);
        long[] num2 = change2Array(s2);

        long carry = 0;
        long[] result = new long[maxLength+1];

        for (int i = maxLength - 1; i >= 0 || carry!=0; i--) {
            long sum = carry;

            if(i>=0){
                sum += num1[i] + num2[i];
            }

            carry = sum / 10;
            sum %= 10;

            result[i+1] = sum;
        }

        return change2String(result);
    }

    private static String append0(String s,int maxLength){
        StringBuilder b = new StringBuilder(s);

        while (b.length()<maxLength){
            b.insert(0,0);
        }

        return b.toString();
    }

    private static long[] change2Array(String s){
        long[] num = new long[s.length()];

        for (int i = 0; i < s.length(); i++) {
            num[i] = s.charAt(i)-'0';
        }

        return num;
    }

    private static String change2String(long[] arr){
        StringBuilder b = new StringBuilder();

        boolean no0 = false;
        for(long l: arr){
            if(l!=0){
                no0 = true;
            }

            if(no0){
                b.append(l);
            }
        }

        return no0?b.toString():"0";
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
