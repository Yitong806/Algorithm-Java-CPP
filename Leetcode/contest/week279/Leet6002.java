package leetcode.contest.week279;

import java.math.BigInteger;
import java.util.BitSet;

public class Leet6002 {
    static class Bitset {
        int size = 0;
        int count1 = 0;
        java.util.BitSet bi;

        public Bitset(int size) {
            bi = new BitSet(size);
            this.size = size;
        }

        public void fix(int idx) {
            if(bi.get(idx)){
                return;
            }

            bi.set(idx);
            count1++;
        }

        public void unfix(int idx) {
            if(!bi.get(idx)){
                return;
            }


            bi.clear(idx);
            count1--;
        }

        public void flip() {
            bi.flip(0, size);
            count1 = size - count1;
        }

        public boolean all() {
            return count1 == size;
        }

        public boolean one() {
            return count1 != 0;
        }

        public int count() {
            return count1;
        }

        public String toString() {
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < size; i++){
                if(bi.get(i)){
                    b.append('1');
                }else {
                    b.append('0');
                }
            }

            return b.toString();
        }
    }
}
