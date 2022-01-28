package leetcode.medium;

public class Leet0002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null;

        ListNode result=null;

        ListNode node1=l1;
        ListNode node2=l2;

        int carry=0;
        while (node1!=null||node2!=null||carry!=0){
            int val = (node1==null?0:node1.val)+ (node2==null?0:node2.val)+carry;
            carry=val/10;
            val = val%10;
            ListNode temp = new ListNode(val);

            node1=(node1==null?null:node1.next);
            node2=(node2==null?null:node2.next);

            if(head==null){
                head=temp;
                result=temp;
            }else{
                result.next=temp;
                result=result.next;
            }
        }



        return head;
    }
    public static class ListNode {
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
