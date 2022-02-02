#include <string>
#include "vector"
using namespace std;

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {

        if(s.length() < p.length()){
            return {};
        }

        int* appearTimeS = new int[26]();
        int* appearTimeP = new int[26]();

        int index = 0;
        while (index < p.length()){
            appearTimeP[p[index] - 'a'] ++;
            appearTimeS[s[index] - 'a'] ++;
            index++;
        }


        int firstIndex = 0, lastIndex = p.length();

        vector<int> v;

        while (lastIndex <= s.length()){
            if(isOK(appearTimeS, appearTimeP)){
                v.push_back(firstIndex);
            }

            if(lastIndex == s.length()){
                break;
            }

            char firstOut = s[firstIndex], lastIn = s[lastIndex];

            appearTimeS[firstOut - 'a']--;
            appearTimeS[lastIn - 'a'] ++;

            firstIndex++;
            lastIndex++;
        }

        free(appearTimeS);
        free(appearTimeP);
        appearTimeS = nullptr;
        appearTimeP = nullptr;

        return v;
    }

    static bool isOK(const int* appearTimeS, const int* appearTimeP){
        for (int i = 0; i < 26; ++i) {
            if(appearTimeP[i] != appearTimeS[i]){
                return false;
            }
        }

        return true;
    }
};