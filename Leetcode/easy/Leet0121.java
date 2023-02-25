package leetcode.easy;

public class Leet0121 {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1;
        int answer = 0;
        while (right < prices.length){
            int currentProfit = prices[right] - prices[left];
            if(prices[right] > prices[left]){
                answer = Math.max(answer, currentProfit);
            }else {
                left = right;
            }

            right++;
        }

        return answer;
    }
}
