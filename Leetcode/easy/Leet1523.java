package leetcode.easy;

public class Leet1523 {
    public int countOdds(int low, int high) {
        return ((high - low) >> 1) + ((high & 1) | (low & 1));
    }
}
