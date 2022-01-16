package leetcode.contest.week276;

public class Leet2139 {
    public int minMoves(int target, int maxDoubles) {
        int moves = 0;
        while (target != 1 && maxDoubles != 0){
            if (target % 2 == 0) {
                maxDoubles--;
                target >>= 1;
            }else {
                target -= 1;
            }
            moves ++;
        }
        moves += (target - 1);
        return moves;
    }
}
