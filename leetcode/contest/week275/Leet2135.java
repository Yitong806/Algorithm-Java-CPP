package leetcode.contest.week275;

import java.util.*;

public class Leet2135 {

    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> hashedValues = new HashSet<>();
        for (String s: startWords){
            hashedValues.add(hashString(s));
        }

        int answer = 0;
        for (String t: targetWords){
            int hash = hashString(t);
            for(char c: t.toCharArray()){
                int newHash = hash ^ (1 << (c - 'a'));
                if(hashedValues.contains(newHash)){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    private int hashString(String s){
        int hash = 0;
        for (char c: s.toCharArray()){
            hash |= (1 << (c - 'a'));
        }
        return hash;
    }

}
