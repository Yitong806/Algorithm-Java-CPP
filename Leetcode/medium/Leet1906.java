public class Leet1906 {
    public int[] minDifference(int[] nums, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] prefixSum = prefixSum(nums);

        for (int i = 0; i < queries.length; i++) {
            answer[i] = query(prefixSum, queries[i][0], queries[i][1]);
        }

        return answer;
    }

    private int[][] prefixSum(int[] nums){
        int[][] ps = new int[nums.length][101];

        for (int i = 0; i < nums.length; i++) {
            if(i != 0){
                System.arraycopy(ps[i - 1],0, ps[i], 0, 101);
            }
            ps[i][nums[i]] += 1;
        }

        return ps;

    }

    private int query(int[][] prefixSum, int left, int right){
        int[] difference;

        if(left == 0){
            difference = prefixSum[right];
        }else {
            difference = new int[101];
            for (int i = 0; i < 101; i++) {
                difference[i] = prefixSum[right][i] - prefixSum[left - 1][i];
            }
        }

        int no0Cause = 0;
        int minimumDifference = 999, lastValue = -1;

        for (int i = 0; i < difference.length; i++) {
            if(difference[i] != 0){
                if(lastValue != -1){
                    int diff = i - lastValue;
                    minimumDifference = Math.min(minimumDifference, diff);
                }

                lastValue = i;
                no0Cause++;
            }
        }

        return no0Cause < 2 ? -1: minimumDifference;
    }
}
