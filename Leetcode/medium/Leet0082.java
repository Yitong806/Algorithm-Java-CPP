public class Leet0082 {
    public ListNode deleteDuplicates(ListNode head) {
        int[] appearTimes = new int[201];
        ListNode current = head;
        while (current != null){
            appearTimes[current.val + 100] += 1;
            current = current.next;
        }

        ListNode resultHead = null, resultCurrent = null;
        current = head;

        while (current != null){
            if(appearTimes[current.val + 100] != 1){
                current = current.next;
                continue;
            }

            current = current.next;
            ListNode newNode = new ListNode(current.val);
            if(resultHead == null){
                resultHead = resultCurrent = newNode;
                resultHead.next = resultCurrent.next = null;
            }else {
                resultCurrent.next = newNode;
                resultCurrent = newNode;
                resultCurrent.next = null;
            }

        }

        return resultHead;
    }
}
