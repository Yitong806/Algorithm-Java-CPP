package CS208OJ.Lab8;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class NumberGame {
    private static final FastReader fastReader=new FastReader(System.in);
    private static final FastWriter fastWriter=new FastWriter(System.out);
    public static void main(String[] args) {
        int n= fastReader.nextInt();
        long m= fastReader.nextLong();
        int length = (int) Math.ceil(Math.log(m) / Math.log(2));
        Operation[]operations=new Operation[n];
        long maxNumber=0;
        for (int i = 0; i < n; i++) {
            String info= fastReader.next();
            long number= fastReader.nextLong();
            maxNumber=Math.max(maxNumber,number);
            operations[i]=new Operation(info,number);
        }
        fastWriter.println(getFinalAnswer(n,m,operations,maxNumber));

        fastReader.close();
        fastWriter.close();
    }
    private static long getFinalAnswer(int n,long m,Operation[]operations,long maxNumber){
        int length=(int) Math.ceil(Math.log(m) / Math.log(2));
        long answer=0;
        boolean b=false;
        for (int i=length-1;i>=0;i--){
            int z=getFinalBit(0,i,operations);
            int o=getFinalBit(1,i,operations);

            if(z<o){
                if(b||(m>>>i&1)==1){
                    answer+= (long) o <<i;
                }
            }else {
                if((m>>>i&1)==1){
                    b=true;
                }
                answer+=(long)z<<i;
            }
        }

        int diff=(int)Math.ceil(Math.log(maxNumber)/Math.log(2))-length;
        while (diff-->0){
            answer+= (long) getFinalBit(0, diff + length, operations) <<(diff+length);
        }

        return answer;
    }

    private static int getFinalBit(int number,int shift,Operation[]operations){
        number<<=shift;
        for (Operation op:operations){
            if(op.type==Operation.AND){
                number&=op.number;
            }else if(op.type==Operation.OR){
                number|=op.number;
            }else {
                number^=op.number;
            }
        }

        number>>>=shift;
        number&=1;
        return number==1?1:0;

    }

    private static class Operation{
        private static final long AND=0L;
        private static final long OR=1L;
        private static final long XOR=2L;

        private final long type;
        private final long number;
        public Operation(String info,long number){
            this.number=number;
            switch (info){
                case "AND":{
                    this.type=AND;
                    break;
                }
                case "OR":{
                    this.type=OR;
                    break;
                }
                case "XOR":{
                    this.type=XOR;
                    break;
                }
                default:{
                    this.type=-1;
                }
            }
        }
    }

    public static void rTest(){
        int max=0;
        int index=0;
        Random r=new Random();
        int x1=r.nextInt(100);
        int x2=r.nextInt(100);
        int x3=r.nextInt(100);
        for (int i = 0; i <= 255; i++) {
            if(max<((i & x1 | x2) ^ x3)){
                max=((i & x1 | x2) ^ x3);
                index=i;
            }

        }
        System.out.println(Integer.toBinaryString(index));
        System.out.println(Integer.toBinaryString(x1));
        System.out.println(Integer.toBinaryString(x2));
        System.out.println(Integer.toBinaryString(x3));
        System.out.println(index+"&55|66^77 = " + ((index & x1 | x2) ^ x3));
        System.out.println(Integer.toBinaryString(((index & x1 | x2) ^ x3)));
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
