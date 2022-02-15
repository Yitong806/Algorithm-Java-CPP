#include "vector"
#include "unordered_map"
using namespace std;

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        unordered_map<int, int> appearTimes;
        for(int n: nums){
            if(appearTimes.find(n) == appearTimes.end()){
                appearTimes[n] = 0;
            }

            appearTimes[n]++;
        }

        for (auto & appearTime : appearTimes){
            if(appearTime.second == 1){
                return appearTime.first;
            }
        }

        return 0;
    }
};