import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Leet0445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = length(l1), length2 = length(l2);
        l1 = ensureLength(l1, length1, Math.max(length1, length2));
        l2 = ensureLength(l2, length2, Math.max(length1, length2));

        ListNode head = add(l1, l2);

        return borrow(head);
    }

    private int length(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    private ListNode ensureLength(ListNode head, int currentLength, int expectedLength) {
        while (currentLength < expectedLength) {
            ListNode l = new ListNode(0);
            l.next = head;
            head = l;
            currentLength++;
        }

        return head;
    }

    private ListNode add(ListNode l1, ListNode l2) {
        ListNode head = null, curr = null, curr1 = l1, curr2 = l2;

        while (curr1 != null && curr2 != null) {
            if (head == null) {
                head = curr = new ListNode(curr1.val + curr2.val);
            } else {
                curr.next = new ListNode(curr1.val + curr2.val);
                curr = curr.next;
            }

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return head;
    }

    private ListNode borrow(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        int carry = 0;

        while (!stack.isEmpty()) {
            stack.peek().val += carry;
            carry = stack.peek().val / 10;
            stack.peek().val %= 10;
            stack.pop();
        }

        if(carry != 0){
            ListNode node = new ListNode(carry);
            node.next = head;
            head =node;
        }

        return head;
    }
}
