package leetcode.contest.week274;

public class Leet2125 {
    public int numberOfBeams(String[] bank) {
        int[] deviceCounts = new int[bank.length];
        for (int i = 0; i < bank.length; i++) {
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    deviceCounts[i]++;
                }
            }
        }

        int answer = 0;
        int previousCount = 0;
        for (int dc: deviceCounts){
            if(dc != 0){
                answer += previousCount * dc;
                previousCount = dc;
            }
        }

        return answer;
    }
}
