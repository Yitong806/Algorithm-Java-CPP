package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Leet0003 {
    // Not Accepted
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        Set<Character> characterSet = new HashSet<>();

        int left = 0, right = 0, answer = 0;
        final int length = cs.length;
        while (right < length){
            char leftChar = cs[left];
            char rightChar = cs[right];
            if(characterSet.contains(rightChar)){
                characterSet.remove(leftChar);
                left++;
            }else {
                characterSet.add(rightChar);
                right++;
                answer = Math.max(answer, characterSet.size());
            }
        }

        return answer;
    }
}
