package syz;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SYZ0025 {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        int n = fastReader.nextInt();
        long[] currentSum = {0};
        long[] currentPow = {1};

        for (int i = 1; i <= n; i++) {
            currentPow = multiply(currentPow,formArray(i));
            currentSum = sum(currentSum,currentPow);
        }

        String answer = formAnswer(currentSum);
        fastWriter.println(answer);

        fastReader.close();
        fastWriter.close();
    }
    private static long[] formArray(long i){
        char[] str = String.valueOf(i).toCharArray();
        long[]array = new long[str.length];
        for (int j = 0; j < array.length; j++) {
            array[j]= str[j]-'0';
        }
        return array;
    }

    private static long[] multiply(long[] num1,long[] num2){

        long[]result = new long[num1.length+num2.length];

        for (int i = num2.length-1; i>=0;i--){
            for (int j = num1.length-1; j >= 0; j--) {
                result[i+j+1] += num2[i]*num1[j];
            }
        }

        int index = result.length - 1;
        long carry = 0;
        while (index>=0){
            long number =result[index]+carry;
            result[index] = number%10;
            carry = number/10;
            index--;
        }

        return result;
    }

    private static long[] sum(long[] num1,long[] num2){
        long[]result = new long[num1.length+num2.length];
        long carry = 0;
        int index1 = num1.length-1;
        int index2 = num2.length-1;

        int resultIndex = result.length-1;
        while (index1>=0 || index2>=0 ||carry!=0){
            long number = carry;
            if(index1>=0){
                number += num1[index1];
                index1--;
            }

            if(index2>=0){
                number += num2[index2];
                index2--;
            }

            carry = number/10;
            number = number%10;

            result[resultIndex] = number;
            resultIndex--;
        }

        return result;
    }

    private static String formAnswer(long[] currentSum){
        StringBuilder b = new StringBuilder();
        boolean no0 = false;
        for (long n:currentSum){
            if(n!=0){
                no0 = true;
            }

            if(no0){
                b.append(n);
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
            writer.close();
        }
    }
}
