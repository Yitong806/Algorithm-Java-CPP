struct ListNode{
    int val;
    ListNode* next;
    ListNode(int val) : val(val), next(nullptr){}
};

class Solution {
public:
    bool hasCycle(ListNode *head) {
        ListNode* slow = head;
        ListNode* fast = head;

        while (slow != nullptr && fast != nullptr && fast->next != nullptr){
            slow = slow->next;
            fast = fast->next->next;

            if(slow == fast){
                return true;
            }


        }

        return false;
    }
};