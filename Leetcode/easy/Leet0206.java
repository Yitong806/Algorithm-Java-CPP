public class Leet0206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            if(next == null){
                break;
            }
            curr = next;
        }

        return curr;
    }
}
