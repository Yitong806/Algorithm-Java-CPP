#include "vector"
using namespace std;

class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        for(char c: letters){
            if(target < c){
                return c;
            }
        }

        return letters[0];
    }
};