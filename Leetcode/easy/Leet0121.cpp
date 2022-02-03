#include "vector"
using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int result = 0;
        int minimumInPrice = prices[0];

        for (int i = 1, sz = prices.size(); i < sz; ++i) {
            int price = prices[i];

            minimumInPrice = min(minimumInPrice, price);

            result = max(result, price - minimumInPrice);

        }

        return result;
    }
};

