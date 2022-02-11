#include "string"

using namespace std;

class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int* appearTimeS1 = new int[26]();
        int* appearTimeS2 = new int[26]();

        for(char c: s1){
            appearTimeS1[c - 'a']++;
        }

        for (int i = 0; i < s1.length(); ++i) {
            appearTimeS2[s2[i] - 'a']++;
        }

        if(isPermutation(appearTimeS1, appearTimeS2)){
            delete[] appearTimeS1;
            delete[] appearTimeS2;

            appearTimeS1 = nullptr;
            appearTimeS2 = nullptr;

            return true;
        }

        for (int i = 0; i + s1.length() < s2.length(); ++i) {

            if(isPermutation(appearTimeS1, appearTimeS2)){
                delete[] appearTimeS1;
                delete[] appearTimeS2;

                appearTimeS1 = nullptr;
                appearTimeS2 = nullptr;

                return true;
            }

            char out = s2[i], in = s2[i + s1.length()];
            appearTimeS2[out - 'a']--;
            appearTimeS2[in - 'a']++;

            if(isPermutation(appearTimeS1, appearTimeS2)){
                delete[] appearTimeS1;
                delete[] appearTimeS2;

                appearTimeS1 = nullptr;
                appearTimeS2 = nullptr;

                return true;
            }
        }

        delete[] appearTimeS1;
        delete[] appearTimeS2;

        appearTimeS1 = nullptr;
        appearTimeS2 = nullptr;

        return false;
    }

    static bool isPermutation(const int* ap1, const int* ap2){
        for (int i = 0; i < 26; ++i) {
            if(ap1[i] != ap2[i]){
                return false;
            }
        }

        return true;
    }
};