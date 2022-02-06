#include "map"
#include "vector"
using namespace std;

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        map<int, int>* appearTime = new map<int, int>();

        for(int i: nums){
            if(appearTime->find(i) != appearTime->end()){
                appearTime ->operator[](i) += 1;
            }else{
                appearTime->insert(pair<int, int>{i, 1});
            }
        }

        auto iterator = appearTime->begin();
        int index = 0;
        while (iterator != appearTime->end()){
            int key = iterator->first, time = iterator->second;
            for (int i = 0; i < min(2, time); ++i) {
                nums[index++] = key;
            }

            iterator++;
        }

        delete appearTime;

        return index;
    }
};