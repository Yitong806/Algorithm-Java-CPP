#include "string"
#include "map"
using namespace std;

class Solution {
public:
    int romanToInt(string s) {
        int v = 0;

        int* symbol_value = new int[26]();

        symbol_value['I' - 'A'] = 1;
        symbol_value['V' - 'A'] = 5;
        symbol_value['X' - 'A'] = 10;
        symbol_value['L' - 'A'] = 50;
        symbol_value['C' - 'A'] = 100;
        symbol_value['D' - 'A'] = 500;
        symbol_value['M' - 'A'] = 1000;

        for (int i = 0, length = s.length(); i < length; ++i) {
            int ops = 1;

            int currentValue = symbol_value[s[i] - 'A'];
            if(i + 1 < s.length()){
                int next = symbol_value[s[i + 1] - 'A'];
                if(currentValue < next){
                    ops = -1;
                }
            }

            v += ops * currentValue;
        }

        delete[] symbol_value;
        symbol_value = nullptr;


        return v;
    }
};