package leetcode.medium;

public class Leet0142 {
    private static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                while (head != fast){
                    head = head.next;
                    fast = fast.next;
                }
                return fast;
            }
        }

        return null;
    }
}
