package leetcode.contest.week280;

import java.util.*;

public class Leet6005 {
    public int minimumOperations(int[] nums) {
        if(nums.length <= 2){
            if(nums.length == 2){
                return nums[0] == nums[1] ? 1: 0;
            }
            return 0;
        }

        Map<Integer, Integer> oddTimes = new HashMap<>(), evenTimes = new HashMap<>();
        int evenLength2 = nums.length / 2, oddLength = nums.length - evenLength2;
        for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 0){
                oddTimes.putIfAbsent(nums[i], 0);
                oddTimes.replace(nums[i], oddTimes.get(nums[i]) + 1);
            }else {
                evenTimes.putIfAbsent(nums[i], 0);
                evenTimes.replace(nums[i], evenTimes.get(nums[i]) + 1);
            }
        }

        List<Map.Entry<Integer, Integer>> entriesOddList = new ArrayList<>(oddTimes.entrySet());
        entriesOddList.sort(Comparator.comparingInt(Map.Entry::getValue));

        List<Map.Entry<Integer, Integer>> entriesEvenList = new ArrayList<>(evenTimes.entrySet());
        entriesEvenList.sort(Comparator.comparingInt(Map.Entry::getValue));

        Map.Entry<Integer, Integer> oddMax1 = null, oddMax2 = null;
        Map.Entry<Integer, Integer> evenMax1 = null, evenMax2 = null;
        int op1 = 0, op2 = 0;
        if(entriesOddList.size() == 1){
            op1 += 0;
        }else {
            oddMax1 = entriesOddList.get(entriesOddList.size() - 1);
            oddMax2 = entriesOddList.get(entriesOddList.size() - 2);
        }


        if(entriesEvenList.size() == 1){
            op2 += 0;
        }else {
            evenMax1 = entriesEvenList.get(entriesEvenList.size() - 1);
            evenMax2 = entriesEvenList.get(entriesEvenList.size() - 2);
        }

        System.out.println(oddMax1);
        System.out.println(oddMax2);
        System.out.println(evenMax1);
        System.out.println(evenMax2);

        if(oddMax1 != null && oddMax2 != null && evenMax1 != null && evenMax2 != null){
            if(!Objects.equals(oddMax1.getKey(), evenMax1.getKey())){
                return (oddTimes.get(oddMax1.getKey()) + evenTimes.get(evenMax1.getKey())) * -1 + nums.length;
            }else {
                int flip1 = evenLength2 - oddTimes.get(oddMax1.getKey()) + oddLength - evenTimes.get(evenMax2.getKey());
                int flip2 = evenLength2 - oddTimes.get(oddMax2.getKey()) + oddLength - evenTimes.get(evenMax1.getKey());

                return Math.min(flip1, flip2);
            }
        }else if(oddMax1 != null && oddMax2 != null){
            if(Objects.equals(oddMax1.getKey(), entriesEvenList.get(0).getKey())){
                op1 = oddLength - oddTimes.get(oddMax2.getKey());
            }else {
                op1 = oddLength - oddTimes.get(oddMax1.getKey());
            }

            op2 = 0;

            return op1 + op2;
        }else if(evenMax1 != null && evenMax2 != null){
            if(Objects.equals(evenMax1.getKey(), entriesOddList.get(0).getKey())){
                op2 = evenLength2 - evenTimes.get(evenMax2.getKey());
            }else {
                op2 = evenLength2 - evenTimes.get(evenMax1.getKey());
            }
            op1 = 0;

            return op1 + op2;
        }else {
            return nums[0] == nums[1] ? Math.min(evenLength2, oddLength) : 0;
        }



    }
}
