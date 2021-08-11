package syz.contest06;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class E {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        int[][] matrix = new int[5][5];

        int[] rowMax = new int[5];
        int[] columnMin = new int[5];

        for (int i = 0; i < 5; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = fastReader.nextInt();
                if(matrix[i][j]>max){
                    max = matrix[i][j];
                }
            }

            rowMax[i] = max;
        }

        for (int i = 0; i < 5; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 5; j++) {
                if(matrix[j][i]<min){
                    min = matrix[j][i];
                }
            }

            columnMin[i] = min;
        }

        boolean found = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(rowMax[i] == matrix[i][j] && columnMin[j] == matrix[i][j]){
                    fastWriter.println((i+1)+" "+(j+1)+" "+matrix[i][j]);
                    found = true;
                }
            }
        }

        if(!found){
            fastWriter.println("not found");
        }

        fastReader.close();
        fastWriter.close();
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
