package syz.problems;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SYZ0019{
    public static void main(String[]args){
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        int n = fastReader.nextInt();
        int q = fastReader.nextInt();

        Soldier[] soldiers = new Soldier[n+1];
        for (int i = 0; i <= n; i++) {
            soldiers[i]= new Soldier(i);
        }

        /* Brute Force:
        for (int i = 0; i < q; i++) {
            int instruction = fastReader.nextInt();
            switch (instruction){
                case 0:{
                    int a = fastReader.nextInt();
                    fastWriter.println(soldiers[a]);
                    break;
                }
                case 1:{
                    int a = fastReader.nextInt();
                    int b = fastReader.nextInt();
                    int dx = fastReader.nextInt();
                    int dy = fastReader.nextInt();
                    for (int j = a; j <= b; j++) {
                        soldiers[j].addXY(dx,dy);
                    }

                    break;
                }
                case 2:{
                    int a = fastReader.nextInt();
                    int b = fastReader.nextInt();
                    int degree = fastReader.nextInt();

                    for (int j = a; j <= b; j++) {
                        soldiers[j].rotate(degree);
                    }
                    break;
                }
            }
        }*/

        fastReader.close();
        fastWriter.close();
    }
    private static class Soldier{
        int index;
        double x;
        double y;

        public Soldier(int index){
            this.index = index;
            this.x = 0;
            this.y = index;
        }

        @Override
        public String toString() {
            return String.format("%.1f %.1f",this.x,this.y);
        }

        public void addXY(double dx,double dy){
            this.x += dx;
            this.y += dy;
        }

        public void rotate(double deg){
            double currentDeg;
            if(this.x==0){
                currentDeg = this.y>0?90:-90;
            }else {
                currentDeg = Math.toDegrees(Math.atan(this.y/this.x));
                if(this.x<0){
                    currentDeg += 180;
                }
            }

            double expectedDeg = currentDeg + deg;
            double distance = Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));

            this.x = Math.cos(Math.toRadians(expectedDeg))*distance;
            this.y = Math.sin(Math.toRadians(expectedDeg))*distance;
        }
    }

    private static class SoldierTree{
        
    }

    private static class SoldierTreeNode{
        int left;
        int right;
        long addX;
        long addY;
        int rotate;

        SoldierTreeNode leftChild;
        SoldierTreeNode rightChild;
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