public class Leet0024 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode curr = head, prev = null;

        ListNode resultHead = null;

        while (curr != null) {
            ListNode n1 = curr, n2 = curr.next;
            if(n2 == null){
                break;
            }

            if(resultHead == null){
                resultHead = curr.next;
            }


            if(prev != null){
                prev.next = n2;
            }

            ListNode nextCurr = n2.next;

            n2.next = n1;
            n1.next = nextCurr;

            curr = nextCurr;
            prev = n1;
        }

        return resultHead;

    }
}
