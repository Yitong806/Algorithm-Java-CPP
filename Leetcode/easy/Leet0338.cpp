#include "string"
#include "vector"
#include "iostream"
#include "bitset"
using namespace std;

class Solution {
public:
    vector<int> countBits(int n) {

        vector<int> v;
        for (int i = 0; i <= n; ++i) {
            auto* bi = new bitset<8*sizeof(int)>(i);
            int out = bi->count();
            v.push_back(out);
            delete bi;
            bi = nullptr;
        }

        return v;

    }
};


