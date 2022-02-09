#include "vector"

using namespace std;

class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {

        int* appearTimes = new int[6]();
        for (int i = 0; i < tops.size(); ++i) {
            int top = tops[i] - 1, bottom = bottoms[i] - 1;

            if(top == bottom){
                appearTimes[top] += 1;
            }else {
                appearTimes[top] += 1;
                appearTimes[bottom] += 1;
            }
        }

        int maximumKind = 0, maximumTimes = appearTimes[0];
        for (int i = 0; i < 6; ++i) {
            if(appearTimes[i] > maximumTimes){
                maximumKind = i;
                maximumTimes = appearTimes[i];
            }
        }

        if(maximumTimes < tops.size()){
            delete[] appearTimes;
            return -1;
        }

        int swapTimesTop = 0, swapTimesBottom = 0;

        for (int i = 0; i < tops.size(); ++i) {
            if(tops[i] - 1 != maximumKind){
                swapTimesTop ++;
            }

            if(bottoms[i] - 1 != maximumKind){
                swapTimesBottom ++;
            }
        }

        delete[] appearTimes;

        return min(swapTimesTop, swapTimesBottom);
    }
};