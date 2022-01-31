#include "vector"
#include "stack"
using namespace std;

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int answer = 0;
        stack<int> increasingIndexStack;
        heights.push_back(0);
        for (int i = 0; i < heights.size(); ++i) {
            int topIndex = increasingIndexStack.empty()? 0 :increasingIndexStack.top();
            if(increasingIndexStack.empty() || heights[topIndex]< heights[i]){
                increasingIndexStack.push(i);
            }else{
                increasingIndexStack.pop();
                int area = heights[topIndex] * (increasingIndexStack.empty() ? i : (i - 1 - increasingIndexStack.top()));
                answer = max(answer, area);
                i--;
            }
        }

        return answer;
    }
};