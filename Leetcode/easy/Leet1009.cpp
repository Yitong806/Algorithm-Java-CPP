#include "bitset"
#include "cmath"
using namespace std;

class Solution {
public:
    int bitwiseComplement(int n) {

        if(n == 0){
            return 1;
        }
        int maxPower = -1;
        while (true){
            int pow1 = pow(2, maxPower);

            int pow2 = pow(2, maxPower + 1);

            if(pow1 < n && n <= pow2 -1){
                maxPower = pow2 - 1;
                break;
            }

            maxPower++;
        }

        return maxPower - n;
    }
};