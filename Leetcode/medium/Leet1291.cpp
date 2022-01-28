#include "vector"
#include "string"
using namespace std;

class Solution {
public:
    static std::vector<int> sequentialDigits(int low, int high) {
        std::vector<int> result;
        for (int i = 1; i <= 9; ++i) {
            for (int j = i + 1; j <= 9; ++j) {
                int built = buildConsecutive(i, j);
                if(low <= built && built <= high){
                    result.push_back(built);
                }
            }
        }

        std::sort(result.begin(), result.end());

        return result;
    }

    static int buildConsecutive(int a,int b){
        int result = 0;
        for (int pow = b, pow10 = 1; pow >= a; --pow , pow10 *= 10) {
            result += pow10 * pow;
        }

        return result;
    }
};