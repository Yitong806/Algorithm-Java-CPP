#include "vector"
#include "map"
using namespace std;

class Solution {
public:
    int fourSumCount(vector<int>& nums1, vector<int>& nums2, vector<int>& nums3, vector<int>& nums4) {
        map<int, int> sum12;
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                if(sum12.find(sum) == sum12.end()){
                    sum12[sum] = 0;
                }

                sum12[sum] += 1;
            }
        }

        int result = 0;
        for (int i : nums3) {
            for (int j : nums4) {
                int sum = i + j;

                if(sum12.find(sum * -1) != sum12.end()){
                    result += sum12[sum * -1];
                }

            }
        }

        return result;
    }
};