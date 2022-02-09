#include <map>
#include "vector"

using namespace std;

class Solution {
public:
    vector<int> maxSubsequence(vector<int> &nums, int k) {
        vector<int>* cpy = new vector<int>(nums);

        std::sort(cpy->begin(), cpy->end());

        vector<int>* kLargest = new vector<int>(cpy->end() - k, cpy->end());
        map<int, int>* appearTimes = new map<int, int>();

        for(int& kl: *kLargest){
            if(appearTimes->find(kl) == appearTimes->end()){
                appearTimes->insert(pair<int, int>(kl,0));
            }
            
            appearTimes ->operator[](kl) ++;
        }

        vector<int> answer;

        for(int i: nums){
            if(appearTimes ->operator[](i) > 0){
                appearTimes ->operator[](i) --;
                answer.push_back(i);
            }
        }

        delete cpy;
        delete kLargest;
        delete appearTimes;

        return answer;
    }
};