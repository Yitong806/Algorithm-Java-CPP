package luogu.main.dp;

import java.io.*;
import java.util.*;
import java.math.*;

public class P1002 {
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        int xb = fastReader.nextInt();
        int yb = fastReader.nextInt();

        int xh = fastReader.nextInt();
        int yh = fastReader.nextInt();

        long[][] chessboard = new long[xb+1][yb+1];

        for (int i = 0; i <= xb; i++) {
            if(isAttackable(i,0,xh,yh)){
                chessboard[i][0] = 0;
                break;
            }else{
                chessboard[i][0] = 1;
            }

        }

        for (int i = 0; i <= yb; i++) {
            if(isAttackable(0,i,xh,yh)){
                chessboard[0][i] = 0;
                break;
            }else{
                chessboard[0][i] = 1;
            }
        }

        for (int i = 1; i <= xb; i++) {
            for (int j = 1; j <= yb; j++) {
                if (isAttackable(i, j, xh, yh) ) {
                    chessboard[i][j] = 0;
                } else {
                    chessboard[i][j] = chessboard[i - 1][j] + chessboard[i][j - 1];
                }
            }
        }

        fastWriter.println(chessboard[xb][yb]);

        fastReader.close();
        fastWriter.close();
    }
    private static boolean isAttackable(int x,int y,int xh,int yh){
        return (Math.abs(x-xh)==2 && Math.abs(y-yh)==1)
                ||(Math.abs(x-xh)==1 && Math.abs(y-yh)==2)
                ||(x==xh&&y==yh);
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
