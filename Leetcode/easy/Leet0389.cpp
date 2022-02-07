#include "string"
#include "map"

using namespace std;

class Solution {
public:
    char findTheDifference(string s, string t) {
        int *appearTimesS = new int[26]();
        int *appearTimesT = new int[26]();

        for(char c:s){
            appearTimesS[c - 'a']++;
        }

        for(char c:t){
            appearTimesT[c - 'a']++;
        }

        for (int i = 0; i < 26; ++i) {
            if(appearTimesT[i] != appearTimesS[i]){

                delete[] appearTimesS;
                delete[] appearTimesT;

                appearTimesS = nullptr;
                appearTimesT = nullptr;

                return (char)(i + 'a');
            }
        }

        delete[] appearTimesS;
        delete[] appearTimesT;

        appearTimesS = nullptr;
        appearTimesT = nullptr;

        return '0';
    }
};