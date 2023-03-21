package leetcode.medium;

public class Leet2348 {
    public long zeroFilledSubarray(int[] nums) {
        int currentIndex = 0;
        long answer = 0;
        while (true){
            while (currentIndex < nums.length && nums[currentIndex] != 0){
                currentIndex += 1;
            }

            if(currentIndex >= nums.length){
                break;
            }

            int start0 = currentIndex;

            int end0 = currentIndex;

            while (end0 < nums.length && nums[end0] == 0){
                end0 += 1;

            }

            answer += (long) (end0 - start0 + 1) * (end0 - start0) / 2;

            currentIndex = end0 + 1;

        }

        return answer;
    }
}
