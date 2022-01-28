package leetcode.contest.week274;

public class Leet2124 {
    public boolean checkString(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == 'b' && s.charAt(i + 1) == 'a'){
                return false;
            }
        }
        return true;
    }
}
