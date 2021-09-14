package CS208OJ.Lab1;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class StableMatching {
    public static void main(String[] args) {
        FastReader fastReader=new FastReader(System.in);
        FastWriter fastWriter=new FastWriter(System.out);
        int n= fastReader.nextInt();

        HashMap<String,Integer> manName_number_hashMap =new HashMap<>();
        HashMap<String,Integer> womanName_number_hashMap =new HashMap<>();
        String[]manNames=new String[n];
        String[]womanNames=new String[n];
        for (int i = 0; i < n; i++) {
            manNames[i]= fastReader.next();
            manName_number_hashMap.put(manNames[i], i);
        }

        for (int i = 0; i < n; i++) {
            womanNames[i]= fastReader.next();
            womanName_number_hashMap.put(womanNames[i], i);
        }

        int[][]man_preference_list=getPreferenceList(fastReader, n, womanName_number_hashMap);

        int[][]woman_preference_list=getPreferenceList(fastReader, n, manName_number_hashMap);

        int[][]reverse=getReversePreference(woman_preference_list,n);

        HashMap<Integer,Integer>woman_man_matched=matching(man_preference_list,woman_preference_list,reverse,n);

        HashMap<Integer,Integer> man_woman =new HashMap<>();
        for (Map.Entry<Integer,Integer> woman_man : woman_man_matched.entrySet()) {
            man_woman.put(woman_man.getValue(), woman_man.getKey());
            /*System.out.println("woman_man.getValue() = " + woman_man.getValue());
            System.out.println("woman_man.getKey() = " + woman_man.getKey());*/
        }

        for (int i = 0; i < n; i++) {
            fastWriter.println(manNames[i]+" "+womanNames[man_woman.get(i)]);
        }
        fastReader.close();
        fastWriter.close();

    }

    private static HashMap<Integer,Integer> matching(int[][]man_preference_list,int[][]woman_preference_list,int[][]woman_reverse,int n){
        int[]matchingStatus=new int[n];

        Queue<Integer> freemanQueue =new LinkedList<>();
        HashMap<Integer,Integer> woman_man_hashMap =new HashMap<>();
        for (int i = 0; i < n; i++) {
            freemanQueue.offer(i);
        }
        
        while (!freemanQueue.isEmpty()){
            int curMan= freemanQueue.poll();
            for (int i = matchingStatus[curMan]; i < n; i++) {
                int curWoman=man_preference_list[curMan][i];
                matchingStatus[curMan]+=1;
                if(woman_man_hashMap.get(curWoman)==null){
                    woman_man_hashMap.put(curWoman,curMan);
                    break;
                }else {
                    int otherMan= woman_man_hashMap.get(curWoman);
                    if(woman_reverse[curWoman][otherMan]>woman_reverse[curWoman][curMan]){
                        woman_man_hashMap.put(curWoman,curMan);
                        freemanQueue.offer(otherMan);
                        break;
                    }
                }
            }
        }

        return woman_man_hashMap;
    }

    private static int[][] getReversePreference(int[][]woman_preference_list,int n){
        int[][]reverse=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int index=woman_preference_list[i][j];
                reverse[i][index]=j;
            }
        }

        return reverse;
    }

    private static int[][] getPreferenceList
            (FastReader fastReader, int n, HashMap<String, Integer> name_number_hashMap) {
        int[][]preference_list=new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String name = fastReader.next();
                int index= name_number_hashMap.get(name);
                preference_list[i][j]=index;
            }
        }
        return preference_list;
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
