#include "string"
using namespace std;

class Solution {
public:
    int reverse(int x) {
        bool isNegative = false;
        string x_str = to_string(x);

        if(x_str[0] =='-'){
            isNegative = true;
            x_str = x_str.substr(1);
        }

        std::reverse(x_str.begin(), x_str.end());
        long long int v = stoll(x_str);

        if(isNegative) {
            v *= -1;
        }

        if(v > 2147483647L || v < -2147483648L){
            return 0;
        } else{
            return (int) v;
        }
    }
};
