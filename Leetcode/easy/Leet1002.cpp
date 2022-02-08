#include "vector"
#include "string"
#include "cstring"
using namespace std;

class Solution {
public:
    vector<string> commonChars(vector<string> &words) {
        int* minimumCommonCharacters = new int[26]();
        memset(minimumCommonCharacters,  0x3f3f3f3f, sizeof(int) * 26);

        for(string s: words){
            int* characters = new int[26]();
            for(char c: s){
                characters[c - 'a']++;
            }

            for (int i = 0; i < 26; ++i) {
                minimumCommonCharacters[i] = min(minimumCommonCharacters[i], characters[i]);
            }

            delete[] characters;
            characters = nullptr;
        }

        vector<string> result;
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minimumCommonCharacters[i]; ++j) {
                result.emplace_back(1, (char)(i + 'a'));
            }

        }

        delete[] minimumCommonCharacters;
        minimumCommonCharacters = nullptr;

        return result;
    }
};