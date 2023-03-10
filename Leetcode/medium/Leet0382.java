package leetcode.medium;

import java.util.Map;
import java.util.Random;

public class Leet0382 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static class Solution {

        private static final Random R = new Random();

        private ListNode head;

        public Solution(ListNode head) {
            this.head = head;
        }

        public int getRandom() {
            ListNode temp = head;
            int answer = 0, number = 0;
            while (temp != null){
                number += 1;
                if(Math.floor(R.nextDouble() * number) == 0){
                    answer = temp.val;
                }

                temp = temp.next;

            }

            return answer;

        }
    }
}
