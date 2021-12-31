package leetcode.medium;

import java.util.Arrays;

public class Leet1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] smaller = new int[queries.length];

        int[] f_queries = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            f_queries[i] = f(queries[i]);
        }

        int[] f_words = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            f_words[i] = f(words[i]);
        }

        Arrays.sort(f_words);

        for (int i = 0; i < queries.length; i++) {
            int queryExpected = f_queries[i];

            int low = 0, high = f_words.length - 1;
            int result = f_words.length;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int f_w = f_words[mid];

                if (queryExpected < f_w) {
                    high = mid - 1;
                    result = mid;
                } else {
                    low = mid + 1;
                }
            }

            smaller[i] = f_words.length - result;
        }

        return smaller;
    }

    public int f(String s) {
        int[] cnt = new int[26];
        char smallest = 'z';
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
            smallest = (char) Math.min(smallest, c);
        }

        return cnt[smallest - 'a'];
    }
}
