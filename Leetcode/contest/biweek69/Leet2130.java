package leetcode.contest.biweek69;

import java.util.Stack;

public class Leet2130 {

    public int pairSum(ListNode head) {
        int size = getSize(head);
        int halfSize = size >> 1;
        Stack<ListNode> listNodeStack = new Stack<>();

        ListNode current = head;
        while (listNodeStack.size() < halfSize) {
            listNodeStack.push(current);
            current = current.next;
        }

        int maxSum = 0;
        while (listNodeStack.size() > 0) {
            int pop = listNodeStack.pop().val;
            int sum = pop + current.val;
            current = current.next;
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    private int getSize(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
