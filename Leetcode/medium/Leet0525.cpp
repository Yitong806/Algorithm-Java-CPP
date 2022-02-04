#define map map<int,int>

#include "vector"
#include "map"
using namespace std;

class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        map* firstIndexMap = new map();
        firstIndexMap->insert(pair<int,int>(0, -1));

        int count = 0, maxLength = 0;

        for (int i = 0; i < nums.size(); ++i) {
            int n = nums[i];
            if(n == 0){
                count += 1;
            }else {
                count -= 1;
            }

            map::iterator result = firstIndexMap->find(count);
            if(result != firstIndexMap->end()){

                maxLength = max(maxLength, i - result->second);
            } else{
                firstIndexMap->insert(pair<int, int>(count, i));
            }
        }

        delete firstIndexMap;

        return maxLength;
    }
};