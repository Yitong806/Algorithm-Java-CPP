#include "vector"
using namespace std;

struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(0), next(next) {}
};

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        vector<int> allValues(1e6);
        for (auto start : lists) {
            while (start != nullptr){
                allValues.push_back(start -> val);
                start = start -> next;
            }
        }

        std::sort(allValues.begin(), allValues.end());

        ListNode* start = nullptr;
        ListNode* current = nullptr;

        for (int i = 0; i < allValues.size(); ++i) {
            if(i == 0){
                start = new ListNode(allValues[i]);
                current = start;
            } else{
                current -> next = new ListNode(allValues[i]);
                current = current -> next;
            }
        }

        return start;
    }
};
