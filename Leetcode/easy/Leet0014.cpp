#include <string>
#include "vector"
using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string minLengthString = strs[0];
        for (string& s: strs){
            if(minLengthString.length() > s.length()){
                minLengthString = s;
            }
        }

        for (int i = 0; i < minLengthString.length(); ++i) {
            char same = minLengthString[i];
            for (auto & str : strs) {
                if(str[i] != same){
                    return minLengthString.substr(0,i);
                }
            }
        }

        return minLengthString;
    }
};