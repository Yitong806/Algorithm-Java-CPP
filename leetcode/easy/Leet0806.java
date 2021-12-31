package leetcode.easy;

public class Leet0806 {

    public int[] numberOfLines(int[] widths, String s) {
        char[] cs = s.toCharArray();
        int lineCount = 1, stringIndex = 0, currentRest = 100;

        while (stringIndex < cs.length) {
            int wide = widths[cs[stringIndex] - 'a'];
            if (currentRest < wide) {
                ++lineCount;
                currentRest = 100;
                --stringIndex;
            } else {
                currentRest -= wide;
            }
            stringIndex++;
        }

        return new int[]{lineCount, 100 - currentRest};
    }

}
