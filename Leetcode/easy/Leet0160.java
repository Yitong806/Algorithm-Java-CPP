public class Leet0160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lengthA = length(headA), lengthB = length(headB);
        if(lengthA > lengthB){
            headA = jump(headA, lengthA - lengthB);
        }else {
            headB = jump(headB, lengthB - lengthA);
        }

        return getIntersect(headA, headB);

    }

    private int length(ListNode head){
        int length = 0;
        while (head != null){
            length ++;
            head = head.next;
        }
        return length;
    }

    private ListNode jump(ListNode head, int jumpDistance){
        while (jumpDistance > 0){
            jumpDistance--;
            head = head.next;
        }

        return head;
    }

    private ListNode getIntersect(ListNode headA, ListNode headB){
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;

            if(headA == null||headB == null){
                return null;
            }
        }

        return headA;
    }
}
