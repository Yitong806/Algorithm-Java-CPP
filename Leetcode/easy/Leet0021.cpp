struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(0), next(next) {}
};

class Solution {
public:
    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2) {
        ListNode *start = nullptr;
        ListNode* current = nullptr;

        while (list1 != nullptr && list2 != nullptr) {
            ListNode* n1 = list1;
            ListNode* n2 = list2;

            ListNode* node;
            if(n1->val <= n2->val){
                node = n1;
                list1 = list1 -> next;
            } else{
                node = n2;
                list2 = list2 -> next;
            }

            if(start == nullptr){
                start = new ListNode(node->val);
                current = start;
            } else{
                current->next = new ListNode(node -> val);
                current = current -> next;
            }


        }

        if(list1!= nullptr){
            if(start == nullptr){
                start = list1;
            } else{
                current -> next =list1;
            }

        } else{
            if(start == nullptr){
                start = list2;
            } else{
                current -> next = list2;
            }

        }

        return start;
    }
};

