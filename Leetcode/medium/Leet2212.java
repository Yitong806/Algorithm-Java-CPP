package leetcode.medium;

import java.util.Arrays;

public class Leet2212 {

    private int[] maximumChoice = new int[12];
    private int maximumAnswer = 0;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        dfs(0, aliceArrows, new int[12], numArrows);
        fix(numArrows, maximumChoice);
        return maximumChoice;
    }

    private void dfs(int currentIndex, int[] aliceArrows, int[] bobArrows, int restNumArrows) {
        if (currentIndex == aliceArrows.length) {
            int score = calculateScore(aliceArrows, bobArrows);
            if (score > maximumAnswer) {
                maximumAnswer = score;
                System.arraycopy(bobArrows, 0, maximumChoice, 0, maximumChoice.length);
            }
            return;
        }

        if (restNumArrows >= aliceArrows[currentIndex] + 1) {
            bobArrows[currentIndex] = aliceArrows[currentIndex] + 1;
            dfs(currentIndex + 1, aliceArrows, bobArrows, restNumArrows - aliceArrows[currentIndex] - 1);
        }

        bobArrows[currentIndex] = 0;

        dfs(currentIndex + 1, aliceArrows, bobArrows, restNumArrows);
    }

    private void fix(int numArrows, int[] bob) {
        int sum = Arrays.stream(bob).sum();
        bob[0] += numArrows - sum;
    }

    private int calculateScore(int[] alice, int[] bob) {
        int score = 0;
        for (int i = 0; i < alice.length; i++) {
            if (bob[i] > alice[i]) {
                score += i;
            }
        }

        return score;
    }
}
