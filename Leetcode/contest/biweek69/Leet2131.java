package leetcode.contest.biweek69;

public class Leet2131 {
    private static final int ALPHABET = 26;

    /*public static void main(String[] args) {
        System.out.println(new Leet2131().longestPalindrome(new String[]{"aa", "gg", "aa"}));
    }*/

    public int longestPalindrome(String[] words) {
        int[][] graph = buildGraph(words);

        int paired = 0;
        boolean sameCenter = false;
        for (int i = 0; i < ALPHABET; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == i) {
                    if (graph[i][j] % 2 == 0) {
                        paired += graph[i][j] * 2;
                    } else {
                        paired += (graph[i][j] / 2) * 4;
                        if (!sameCenter) {
                            paired += 2;
                            sameCenter = true;
                        }
                    }

                } else {
                    paired += Math.min(graph[i][j], graph[j][i]) * 4;
                }

            }
        }

        return paired;
    }

    private int[][] buildGraph(String[] words) {
        int[][] graph = new int[ALPHABET][ALPHABET];
        for (String word : words) {
            graph[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }
        return graph;
    }
}
