package leetcode.medium;

import java.util.Arrays;

public class Leet0003 {
    // Not Accepted
    public int lengthOfLongestSubstring(String s) {
        char[]cs = s.toCharArray();
        int start = 0, end = 0, indexStart = 0, indexEnd = 0;

        boolean[]contains = new boolean[260];
        Arrays.fill(contains,false);

        int length = 0;
        while (indexEnd < cs.length) {

            while (indexEnd < cs.length&&!contains[cs[indexEnd]]) {
                contains[cs[indexEnd]]=true;
                indexEnd++;
            }

            if (indexEnd - indexStart > length) {
                start = indexStart;
                end = indexEnd;
                length = indexEnd - indexStart;
            }

            contains[cs[indexStart]] = false;
            indexStart++;
            indexEnd++;


        }

        return end-start;
    }
}
