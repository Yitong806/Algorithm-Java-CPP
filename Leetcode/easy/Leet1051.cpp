#include "vector"

using namespace std;

class Solution {
public:
    int heightChecker(vector<int>& heights) {
        vector<int> v(heights.size());

        for (int i = 0; i < heights.size(); ++i) {
            v[i] = heights[i];
        }

        std::sort(v.begin(), v.end());

        int count = 0;
        for (int i = 0; i < heights.size(); ++i) {
            if(v[i] != heights[i]){
                count ++;
            }
        }

        return count;
    }
};