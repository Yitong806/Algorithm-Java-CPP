package leetcode.contest.biweek71;

public class Leet2162 {
    int currentPlace;
    int currentCost;

    public void calculateCost(String targetTime, int index, int moveCost, int pushCost){
        if(index >= targetTime.length()){
            return;
        }
        int targetDigit = targetTime.charAt(index);
        if(targetDigit != currentPlace){
            currentCost += moveCost;
            currentPlace = targetDigit;
        }

        currentCost += pushCost;
        calculateCost(targetTime, index + 1, moveCost, pushCost);

    }

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int maxMinutes = targetSeconds / 60;

        int finalCost = 999999999;
        for (int i = 0; i <= maxMinutes; i++) {
            int minute = i, second = targetSeconds - minute * 60;
            if(second <0 || second >= 100 || minute < 0 || minute >= 100){
                continue;
            }

            currentPlace = startAt;
            currentCost = 0;

            String s = Integer.toString((minute / 10) * 1000 + minute % 10 * 100 + second);


            calculateCost(s,0,moveCost, pushCost);
            finalCost = Math.min(finalCost, currentCost);
        }

        return finalCost;
    }
}
