#include "vector"
#include "string"
#include "map"
#include "iostream"

using namespace std;

class Solution {
public:
    map<char, string> m;
    vector<string> answer;

    vector<string> letterCombinations(string digits) {
        if(digits.empty()){
            return {};
        }

        m.clear();
        answer.clear();
        auto* sz = new string[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 2; i <= 9; ++i) {
            m[(char)(i + '0')] = sz[i - 2];
        }

        bfs(digits, "");

        delete[] sz;

        return answer;
    }

    void bfs(const string& digits, const string built) {
        if(built.length() == digits.length()){
            answer.push_back(built);
            return;
        }

        int index = built.length();

        string s = m[digits[index]];

        for(char c:s){
            string temp = built + c;

            bfs(digits, temp);
        }
    }
};