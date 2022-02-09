#include "string"

using namespace std;

class Solution {
public:
    int numDecodings(string s) {
        if (s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return s[0] == '0' ? 0 : 1;
        }

        int *dpArray = new int[s.length() + 1]();
        dpArray[0] = 1;
        if (s[0] == '0') {
            dpArray[1] = 0;
        } else {
            dpArray[1] = 1;
        }

        for (int i = 2; i <= s.length(); ++i) {
            int oneCharacter = s[i - 1] - '0';
            if(1 <= oneCharacter && oneCharacter <= 9) {
                dpArray[i] += dpArray[i - 1];
            }

            int twoCharacter = (s[i - 2] - '0') * 10 + s [i - 1] - '0';
            if(10 <= twoCharacter && twoCharacter <= 26){
                dpArray[i] += dpArray[i - 2];
            }
        }

        int answer = dpArray[s.length()];
        delete[] dpArray;
        return answer;
    }
};