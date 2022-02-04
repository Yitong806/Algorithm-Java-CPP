#include "vector"
#include "set"
#include "map"
#include "iostream"

using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int> &nums) {
        set<int> uniqueNumbers;
        map<int, int> appearTimes;

        for (int i: nums) {
            uniqueNumbers.insert(i);
            if (appearTimes.find(i) != appearTimes.end()) {
                appearTimes[i] += 1;
            } else {
                appearTimes[i] = 1;
            }
        }
        vector<vector<int>> answer;
        vector<int> uniques;

        uniques.reserve(uniqueNumbers.size());
        for (int i: uniqueNumbers) {
            uniques.push_back(i);

            if (i == 0 && appearTimes[i] >= 3) {
                answer.push_back({0, 0, 0});
            } else if (i != 0 && uniqueNumbers.find(i * -2) != uniqueNumbers.end() && appearTimes[i] >= 2) {
                answer.push_back({i, i, i * -2});
            }
        }

        std::sort(uniques.begin(), uniques.end());

        for (int i = 0; i < uniques.size(); ++i) {
            int left = i, middle = i + 1, right = uniques.size() - 1;

            while (left < middle && middle < right) {
                int sum = uniques[left] + uniques[middle] + uniques[right];
                if (sum < 0) {
                    middle++;
                } else if (sum == 0) {
                    answer.push_back({uniques[left], uniques[middle], uniques[right]});
                    cout<<uniques[left]<<","<<uniques[middle]<<","<<uniques[right]<<endl;
                    middle++;
                    right--;
                } else {
                    right--;
                }
            }
        }


        return answer;

    }
};