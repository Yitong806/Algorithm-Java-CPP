package CS208OJ.Lab2;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class ProgrammingContest {
    //24,18,12,8
    //24+18=42; 18+12+8=38;
    public static void main(String[] args) {
        FastReader fastReader = new FastReader(System.in);
        FastWriter fastWriter = new FastWriter(System.out);

        int t = fastReader.nextInt();
        for (int i = 0; i < t; i++) {
            int n = fastReader.nextInt();
            boolean[] appeared = new boolean[200010];
            int kinds = 0;
            for (int j = 0; j < n; j++) {
                int index = fastReader.nextInt();
                if (!appeared[index]) {
                    kinds++;
                }
                appeared[index] = true;
            }

            Integer[] array = new Integer[kinds];
            for (int j = 0, index = 0; j < 200010; j++) {
                if (appeared[j]) {
                    array[index] = j;
                    index++;
                }
            }
            fastWriter.println(getAnswer(array, kinds));
        }
        fastReader.close();
        fastWriter.close();
    }
    private static int getAnswerByBruteForce(int[]array, int kinds){
        int maxSum=0;
        for (int i = kinds-1; i >= 0; i--) {

            int curSum=array[i];
            if(curSum*3<=maxSum){
                break;
            }
            int first=array[i];
            int second=-1;
            int third=-1;


            for (int j = i-1; j >= 0; j--) {
                if(first%array[j]!=0){
                    if(second==-1){
                        curSum+=array[j];
                        second=array[j];
                    }else if(second%array[j]!=0&&third==-1){
                        curSum+=array[j];
                        third=array[j];
                    }

                    if(second!=0&&third!=-1){
                        break;
                    }
                }

            }

            maxSum=Math.max(maxSum,curSum);
        }

        return maxSum;
    }

    private static int getAnswer(Integer[] array, int kinds) {
        Arrays.sort(array, Comparator.comparingInt(o -> o * -1));

        if (kinds == 1) {
            return array[0];
        } else if (kinds == 2) {
            return (array[0] + array[1]) % array[1] == 0 ?
                    array[0] :
                    array[0] + array[1];
        } else {
            if ((array[0]+array[1]) % array[1] != 0) {
                int answer = array[0] + array[1];
                for (int i = 2; i < kinds; i++) {
                    if ((array[0] + array[i]) % array[i] != 0 &&
                            (array[1] + array[i]) % array[i] != 0) {
                        answer += array[i];
                        break;
                    }
                }
                return answer;
            } else {
                if (array[0] == 2 * array[1]) {
                    int answer1 = array[0];
                    int answer2 = array[1];
                    for (int i = 0, count = 0; i < kinds; i++) {
                        if ((array[0] + array[i]) % array[i] != 0) {
                            answer1 += array[i];
                            count++;
                        }
                        if (count >= 2) {
                            break;
                        }
                    }

                    for (int i = 1, count = 0; i < kinds; i++) {
                        if ((array[1] + array[i]) % array[i] != 0) {
                            answer2 += array[i];
                            count++;
                        }
                        if (count >= 2) {
                            break;
                        }
                    }
                    return Math.max(answer1, answer2);
                } else {
                    int answer = array[0];
                    for (int i = 0, count = 0; i < kinds; i++) {
                        if ((array[0] + array[i]) % array[i] != 0) {
                            answer += array[i];
                            count++;
                        }
                        if (count >= 2) {
                            break;
                        }
                    }
                    return answer;
                }
            }
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
            while (!st.hasMoreTokens()) {
                String s = nextLine();
                if (s == null) return false;
                eat(s);
            }
            return true;
        }

        public String next() {
            hasNext();
            return st.nextToken();
        }

        public boolean nextBoolean() {
            return Boolean.parseBoolean(next());
        }


        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        public BigDecimal nextBigDecimal() {
            return new BigDecimal(next());
        }

        public void close() {
            try {
                st = null;
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }

        }
    }

    private static class FastWriter implements Closeable {
        private final PrintWriter writer;

        public FastWriter(OutputStream out) {
            this.writer = new PrintWriter(out);
        }

        public void print(Object object) {
            writer.write(object.toString());
        }

        public void printf(String format, Object... os) {
            writer.write(String.format(format, os));
        }

        public void println() {
            writer.write(System.lineSeparator());
        }

        public void println(Object object) {
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
