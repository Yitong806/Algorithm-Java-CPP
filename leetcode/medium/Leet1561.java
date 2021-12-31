package leetcode.medium;

import java.util.Arrays;

public class Leet1561 {

    public int maxCoins(int[] piles) {
        Arrays.parallelSort(piles);
        int myCoin = 0;
        int aliceIndex = piles.length - 1;

        int used = 0;
        while (used < piles.length){
            used += 3;
            myCoin += piles[aliceIndex - 1];
            aliceIndex -= 2;
        }

        return myCoin;
    }
}
