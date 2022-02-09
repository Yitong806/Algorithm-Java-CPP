#include "vector"
#include "map"

using namespace std;

class Solution {
public:
    int findPairs(vector<int> &nums, int k) {
        map<int, int> appearTimes;
        for (int & num : nums) {
            if(appearTimes.find(num) == appearTimes.end()){
                appearTimes[num] = 0;
            }

            appearTimes[num] += 1;
        }

        int pairs = 0;

        for(auto ite = appearTimes.begin(); ite != appearTimes.end(); ite ++){
            int key = ite->first;

            if(k != 0){
                if(appearTimes.find(key - k) != appearTimes.end()){
                    pairs += 1;
                }

                if(appearTimes.find(key + k) != appearTimes.end()){
                    pairs += 1;
                }
            }else{
                if(ite->second > 1){
                    pairs += 2;
                }
            }


        }

        return pairs / 2;
    }
};