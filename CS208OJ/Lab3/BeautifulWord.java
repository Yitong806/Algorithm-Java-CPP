package CS208OJ.Lab3;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class BeautifulWord {
    private static long answer=0;
    private static int[][]map;
    private static int[]sum;
    private static boolean[]state;
    private static HashMap<Character,Integer>hashMap;
    public static void main(String[] args) {
        FastReader fastReader=new FastReader(System.in);
        FastWriter fastWriter=new FastWriter(System.out);

        int t= fastReader.nextInt();
        for (int i = 0; i < t; i++) {
            char[]cs=fastReader.next().toCharArray();

            fastWriter.println(getAnswerByDFS(cs));
            //fastWriter.println("BFS:"+getAnswerByBFS(cs));
        }

        fastReader.close();
        fastWriter.close();
    }
    private static long getAnswerByDFS(char[]cs){
        answer=0;
        buildHashMap();
        setMap(cs);
        dfs(-1,0);
        //System.out.println("answer = " + answer);
        return answer;
    }

    private static void setMap(char[]cs){
        map=new int[21][21];
        for (int i = 0; i < cs.length-1; i++) {
            char c1 =cs[i];
            char c2=cs[i+1];
            if(c1 !='a'&& c1 !='e'&& c1 !='i'&& c1 !='u'&& c1 !='o'&&
            c2 !='a'&& c2 !='e'&& c2 !='i'&& c2 !='u'&& c2 !='o'){
                if(c2!=c1){
                    map[hashMap.get(c1)][hashMap.get(c2)]++;
                    map[hashMap.get(c2)][hashMap.get(c1)]++;
                }
            }
        }

        /*for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }*/

        sum=new int[21];
        for (int i = 0; i < 21; i++) {
            int s=0;
            for (int j = 0; j < 21; j++) {
                if(i!=j){
                    s+=map[i][j];
                }

            }
            sum[i]=s;
        }

        state=new boolean[21];
        Arrays.fill(state,false);
    }
    private static void buildHashMap(){
        hashMap=new HashMap<>();
        int count=0;
        for (char c='a';c<='z';c++){
            if(c!='a'&&c!='e'&&c!='i'&&c!='u'&&c!='o'){
                if(!hashMap.containsKey(c)){
                    hashMap.put(c,count);
                    count++;
                }

            }
        }
    }
    private static void dfs(int level,int temp_answer) {
        if(level==-1){
            state[0] = true;
            dfs(0, temp_answer);
        }else {
            int ans = temp_answer;
            if (state[level]) {
                ans += sum[level];
                for (int i = 0; i < 21; i++) {
                    if(state[i]){
                        ans -= 2* map[level][i];
                    }
                }
            }
            answer = Math.max(ans, answer);

            if(level>=20){
                return;
            }

            state[level + 1] = true;
            dfs(level + 1, ans);
            state[level + 1] = false;
            dfs(level + 1, ans);
        }
    }



    private static long getAnswerByBFS(char[]cs){
        Vertex.maxValue=-1;
        int kinds=getKinds(cs);
        Vertex.setHashMap(cs);
        HashMap<Character,Integer>char_int_hashMap=Vertex.char_int_hashMap;
        HashMap<Integer,Character>int_char_hashMap=Vertex.int_char_hashMap;
        int[][]map=buildMap(cs,kinds,char_int_hashMap);
        int[]sum=buildSum(map,kinds);

        Vertex.map=map;
        Vertex.sum=sum;

        Vertex[]vertices=new Vertex[(int)(Math.pow(2,kinds)-1)];
        for (int i = 0; i < vertices.length; i++) {

            int index=(int)(Math.ceil(Math.log(i+2)/Math.log(2))-1);
            char c=int_char_hashMap.get(index);
            boolean isUpper=(i%2==1);

            Vertex father;
            if(i==0){
                father=null;
            }else if(isUpper){
                father=vertices[(i-1)/2];
            }else {
                father=vertices[(i-2)/2];
            }

            vertices[i]=new Vertex(c,isUpper,father);
        }

        /*long max=0;
        for (int i=(int)(Math.pow(2,kinds-1)-1);i< vertices.length;i++){
            max=Math.max(vertices[i].value,max);
        }*/

        return Vertex.maxValue;

    }
    private static class Vertex{
        static int[][]map;
        static int[]sum;
        static HashMap<Character,Integer>char_int_hashMap;
        static HashMap<Integer,Character>int_char_hashMap;
        boolean[]isUpperCases;
        boolean thisIsUpper;
        int value=0;
        static int maxValue;
        public static void setHashMap(char[]cs){
            Vertex.char_int_hashMap=get_char_int_hashMap(cs);
        }

        public Vertex(char c,boolean isUpper,Vertex father){
            isUpperCases=new boolean[char_int_hashMap.size()];
            if(father!=null){
                System.arraycopy(father.isUpperCases,0,this.isUpperCases,0,this.isUpperCases.length);
            }

            int index=char_int_hashMap.get(c);
            isUpperCases[index]=isUpper;
            thisIsUpper=isUpper;

            if(thisIsUpper){
                if(father==null){
                    this.value=0;
                }else {
                    this.value= father.value;
                }
                this.value+=sum[index];
                for (int i = 0; i < isUpperCases.length; i++) {
                    if(isUpperCases[i]&&i!=index){
                        this.value-=2*map[index][i];
                    }
                }

            }else {
                if(father==null){
                    this.value=0;
                }else {
                    this.value= father.value;
                }

            }

            Vertex.maxValue=Math.max(Vertex.maxValue,this.value);
        }

    }

    private static int getKinds(char[]cs){
        HashSet<Character> characters=new HashSet<>();
        for (char c:cs){
            if(c!='a'&&c!='e'&&c!='i'&&c!='u'&&c!='o'){
                characters.add(c);
            }
        }
        return characters.size();
    }
    private static int[][]buildMap(char[] cs, int kinds,
                                   HashMap<Character, Integer> char_int_hashMap){
        int[][]map=new int[kinds][kinds];
        for (int i = 0; i < cs.length-1; i++) {
            try{
                if(char_int_hashMap.containsKey(cs[i])&&char_int_hashMap.containsKey(cs[i+1])){
                    int x1=char_int_hashMap.get(cs[i]);
                    int x2=char_int_hashMap.get(cs[i+1]);
                    map[x1][x2]++;
                    map[x2][x1]++;
                }

            } catch (NullPointerException ignored){

            }
        }
        return map;
    }
    private static int[]buildSum(int[][]map,int kinds){
        int[]sum=new int[kinds];
        for (int i = 0; i < kinds; i++) {
            for (int j = 0; j < kinds; j++) {
                if(i!=j){
                    sum[i]+=map[i][j];
                }
            }
        }
        return sum;
    }

    private static HashMap<Character,Integer>get_char_int_hashMap(char[]cs){
        HashMap<Character,Integer>map=new HashMap<>();
        HashMap<Integer,Character>map2=new HashMap<>();
        int count=0;
        for (char c:cs){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                continue;
            }
            if(!map.containsKey(c)){
                map2.put(count,c);
                map.put(c,count);
                count++;
            }
        }
        Vertex.int_char_hashMap=map2;
        return map;
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
