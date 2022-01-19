public class Leet0142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        
        while(temp != null){
            if(set.contains(temp)){
                return temp;
            }else{
                set.add(temp);
                temp = temp.next;
            }
        }
        
        return null;
    }
}
