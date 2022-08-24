public class Leet0234 {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }

        ListNode mid = midSplit(head);

        ListNode midReverse = reverse(mid);

        return compare(head, midReverse);
    }



    private ListNode midSplit(ListNode head){
        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode split = slow.next;
        slow.next = null;

        System.out.println(split.val);

        return split;

    }

    private ListNode reverse(ListNode head){
        ListNode current1 = head, current2 = head.next;

        while (current2 != null){
            ListNode temp = current2.next;
            current2.next = current1;
            current1 = current2;
            current2 = temp;
        }

        head.next = null;

        return current1;
    }

    private boolean compare(ListNode n1, ListNode n2){
        System.out.println(n1.val+" "+n2.val);
        while (n1 != null && n2 != null){
            System.out.println(n1.val+" "+n2.val);
            if(n1.val != n2.val){
                return false;
            }

            n1 = n1.next;
            n2 = n2.next;
        }

        return true;
    }
}
