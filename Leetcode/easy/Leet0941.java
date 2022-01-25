package leetcode.easy;

public class Leet0941 {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        boolean isDecrease = false, isIncrease = false;
        int previous = -1;

        for (int i : arr) {
            if(previous == -1){
                previous = i;
                continue;
            }

            if (i > previous) {
                if (isDecrease) {
                    return false;
                }
                isIncrease = true;
            }

            if (i < previous) {

                if (!isIncrease) {
                    return false;
                }
                isDecrease = true;
            }

            if(i == previous){
                return false;
            }

            previous = i;
        }

        return isIncrease && isDecrease;
    }
}
