package CS208OJ.Lab7;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class DoingHomework {
    private static final StreamTokenizer in=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
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
        int n = nextInt();
        ArrayList<Task> allTasks = new ArrayList<>(5000);
        ArrayList<Long> activeTimeslot = new ArrayList<>(5000);

        for (int i = 0; i < n; i++) {
            long si = nextLong();
            long ti = nextLong();
            long wi = nextLong();
            allTasks.add(new Task(si, ti, wi));
        }

        allTasks.sort(Comparator.comparingLong(e -> e.si));
        long currentTime = 0;
        for (int i = 0; i < n; i++) {
            currentTime = Math.max(currentTime + 1, allTasks.get(i).si);
            activeTimeslot.add(currentTime);
        }

        allTasks.sort(Comparator.comparingLong(e -> e.wi * -1));
        for(Task t:allTasks){
            setTaskTime(0,t,activeTimeslot,allTasks);
        }

        long answer=0;
        for (Task t:Task.chosen){
            answer+=t.wi;
        }

        fastWriter.println(answer);
        fastWriter.close();
    }

    private static boolean setTaskTime(int index,Task t,
                                       ArrayList<Long>activeTimeslot,ArrayList<Task>allTasks){
        if(activeTimeslot.get(index)>t.ti){
            return false;
        }

        if(Task.taskHashMap.get(index)==null){
            Task.chosen.add(t);
            Task.taskHashMap.put(index,t);
            return true;
        }else {
            Task origin=Task.taskHashMap.get(index);
            if(t.ti> origin.ti){
                return setTaskTime(index+1,t,activeTimeslot,allTasks);
            }else {
                if(setTaskTime(index+1,origin,activeTimeslot,allTasks)){
                    Task.chosen.add(t);
                    Task.taskHashMap.put(index,t);
                    return true;
                }
                return false;
            }
        }

    }

    private static class Task {
        static final HashSet<Task>chosen=new HashSet<>(5000);
        static final HashMap<Integer,Task>taskHashMap=new HashMap<>(5000);
        long si;
        long ti;
        long wi;
        boolean done;
        public Task(long si,long ti,long wi){
            this.si=si;
            this.ti=ti;
            this.wi=wi;
            this.done=false;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "si=" + si +
                    ", ti=" + ti +
                    ", wi=" + wi +
                    '}';
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
            writer.flush();
            writer.close();
        }
    }
}
