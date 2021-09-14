package CS208OJ.Lab11;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class TriangleTest {
    private static final StreamTokenizer in
            =new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static final FastWriter fastWriter=new FastWriter(System.out);

    private static int nextInt(){
        try{
            in.nextToken();
            return (int)in.nval;
        }catch (IOException e){
            return -1;
        }
    }
    private static long nextLong(){
        try{
            in.nextToken();
            return (long)in.nval;
        }catch (IOException e){
            return -1;
        }
    }

    public static void main(String[] args) {

        int n=nextInt();
        int[]numbers=new int[n];
        for (int i=0;i<n;i++){
            numbers[i]=nextInt();
        }

        Arrays.sort(numbers);

        int max=numbers[n-1];
        int[] cnt=new int[max+1];
        for (int i = 0; i < n; i++) {
            int index=numbers[i];
            cnt[index]++;
        }

        Complex[] fCnt=Complex.padding(cnt);
        Complex[] tmp=Complex.convolve(fCnt);

        long[]sum=new long[2*max+1];

        for (int i = 0; i < sum.length; i++) {
            sum[i]=
                    (int)(tmp[i].real+0.5);
        }

        for (int i = 0; i < n; i++) {
            int index=2*numbers[i];
            sum[index]--;
        }

        for (int i = 0; i < sum.length; i++) {
            sum[i]>>=1;
        }

        long[]preSum=new long[sum.length];

        for (int i = 1; i < sum.length; i++) {
            preSum[i]=preSum[i-1]+sum[i];
        }

        long answer=n*preSum[preSum.length-1];

        for (int i = 0; i < n; i++) {
            int index=numbers[i];
            long subed=preSum[index]+ (long) i * (n - 1 - i) + (long)(n-1)+(long)(n-1-i)*(n-i-2)/2;

            answer-=subed;
        }

        fastWriter.println(answer);

        fastWriter.close();
    }
    private static int bitReverse(int n,int bits){
        int reverse=n;
        int count=bits-1;
        n/=2;
        while (n>0){
            reverse=(reverse<<1)|(n&1);
            count--;
            n>>=1;
        }

        return (reverse<<count)&((1<<bits)-1);
    }

    private static class Complex{
        static final Complex ZERO=new Complex(0,0);
        double real;
        double imaginary;

        public Complex(double r,double i){
            this.real=r;
            this.imaginary=i;
        }

        public Complex add(Complex c){
            return new Complex(this.real+c.real,this.imaginary+c.imaginary);
        }

        public Complex sub(Complex c){
            return new Complex(this.real-c.real,this.imaginary-c.imaginary);
        }

        public Complex mul(Complex c){
            return new Complex(this.real*c.real-this.imaginary*c.imaginary,
                    this.real*c.imaginary+this.imaginary*c.real);
        }

        public Complex scale(double t){
            return new Complex(t*this.real,t*this.imaginary);
        }

        public Complex conjugate(){
            return new Complex(this.real,this.imaginary*-1);
        }

        public static Complex[] padding(int[]ori){
            int length=1;
            while (length<ori.length){
                length<<=1;
            }

            Complex[]cns=new Complex[length];
            for (int i = 0; i < length; i++) {
                if(i<ori.length){
                    cns[i]=new Complex(ori[i],0);
                }else {
                    cns[i]=new Complex(0,0);
                }
            }

            return cns;
        }

        public static Complex[] convolve(Complex[] cns){
            Complex[]result=new Complex[cns.length*2];
            for (int i = 0; i < result.length; i++) {
                if(i< cns.length){
                    result[i]=cns[i];
                }else {
                    result[i]=ZERO;
                }
            }

            return cConvolve2(result);
        }

        public static void FFT(Complex[]cns){
            int bit=(int)(Math.log(cns.length)/Math.log(2));

            for (int i = 1; i < cns.length; i++) {
                int swap=bitReverse(i,bit);

                if(i<swap){
                    Complex cn=cns[i];
                    cns[i]=cns[swap];
                    cns[swap]=cn;
                }
            }

            for (int i = 2; i <= cns.length; i<<=1) {
                double wnReal=Math.cos(2*Math.PI/i);
                double wnImaginary=Math.sin(2*Math.PI/i);
                Complex wn=new Complex(wnReal,wnImaginary);
                for (int j = 0; j < cns.length; j+=i) {
                    Complex w=new Complex(1,0);
                    for (int k = 0; k < i / 2; k++) {
                        int even=j+k;
                        int odd=even+i/2;
                        Complex e=cns[even];
                        Complex o=cns[odd];

                        Complex exp=w.mul(o);

                        cns[even]=e.add(exp);
                        cns[odd]=e.sub(exp);

                        w=w.mul(wn);
                    }
                }
            }
        }

        public static Complex[] IFFT(Complex[]cns){
            for (int i = 0; i < cns.length; i++) {
                cns[i]=cns[i].conjugate();
            }

            FFT(cns);

            for (int i = 0; i < cns.length; i++) {
                cns[i]=cns[i].conjugate();
            }

            for (int i = 0; i < cns.length; i++) {
                cns[i]=cns[i].scale(1.0/ cns.length);
            }

            return cns;
        }

        public static Complex[] cConvolve2(Complex[]cns){
            FFT(cns);
            for (int i = 0; i < cns.length; i++) {
                cns[i]=cns[i].mul(cns[i]);
            }

            return IFFT(cns);
        }
    }

    private static long getAnswerByBruteForce(int[]array,int n){
        long count=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if(array[i]+array[j]>array[k]&& array[i]+array[k]>array[j]
                            && array[j]+array[k]>array[i]){
                        count++;
                    }
                }
            }
        }

        return count;
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
