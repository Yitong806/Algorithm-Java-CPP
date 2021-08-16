package luogu.main.tree;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class P1030 {

    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        String infix = fastReader.next();
        String postfix = fastReader.next();

        TreeNode root = buildTree(infix,postfix, 0,infix.length()-1,0,postfix.length()-1);
        preorder(root,fastWriter);

        fastReader.close();
        fastWriter.close();
    }
    private static TreeNode buildTree(String infix, String postfix,
                                      int infixLeft, int infixRight,
                                      int postfixLeft, int postfixRight){
        if(infix.isEmpty() || postfix.isEmpty()){
            return null;
        }

        if(infixLeft>infixRight||postfixLeft> postfixRight){
            return null;
        }

        char rootChar = postfix.charAt(postfixRight);
        int rootCharIndex = infix.indexOf(rootChar);
        TreeNode root = new TreeNode(rootChar);

        int nextInfixLeft_left = infixLeft;
        int nextInfixRight_left = rootCharIndex - 1;

        int nextInfixLeft_right = rootCharIndex + 1;
        int nextInfixRight_right = infixRight;

        int nextLength_left = nextInfixRight_left - nextInfixLeft_left + 1;
        int nextLength_right = nextInfixRight_right - nextInfixLeft_right + 1;

        int nextPostfixRight_right = postfixRight - 1;
        int nextPostfixLeft_right = nextPostfixRight_right - nextLength_right + 1;

        int nextPostfixRight_left = nextPostfixLeft_right - 1;
        int nextPostfixLeft_left = nextPostfixRight_left - nextLength_left + 1;

        root.leftChild = buildTree(infix,postfix,nextInfixLeft_left,
                nextInfixRight_left,nextPostfixLeft_left,nextPostfixRight_left);

        root.rightChild = buildTree(infix,postfix, nextInfixLeft_right,
                nextInfixRight_right,nextPostfixLeft_right,nextPostfixRight_right);

        return root;
    }

    public static void preorder(TreeNode root, FastWriter fastWriter){
        if(root==null){
            return;
        }

        fastWriter.print(root.value);
        preorder(root.leftChild,fastWriter);
        preorder(root.rightChild,fastWriter);

    }

    private static class TreeNode{
        char value;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(char c){
            this.value = c;
        }
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
