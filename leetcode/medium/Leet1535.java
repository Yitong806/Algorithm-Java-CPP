package leetcode.medium;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Leet1535 {
    public int getWinner(int[] arr, int k) {
         int max = arr[0], count = 0, index = 1;
         while (index < arr.length && count < k){
             if(arr[index] > max){
                 max = arr[index];
                 count = 1;
             }else {
                 count++;
             }
             index++;
         }
         return max;
    }

}
