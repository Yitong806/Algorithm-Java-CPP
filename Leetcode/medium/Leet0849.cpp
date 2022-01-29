#include "vector"

using namespace std;

class Solution {
public:
    int maxDistToClosest(vector<int> &seats) {
        vector<int> builtSeatsIndex = buildSeats(seats);
        return getDistance(builtSeatsIndex, seats);
    }

    vector<int> buildSeats(vector<int> &seats) {
        vector<int> indexes;
        for (int i = 0; i < seats.size(); ++i) {
            if (seats[i] != 0) {
                indexes.push_back(i);
            }
        }

        return indexes;
    }

    int getDistance(vector<int> &seatIndexes, vector<int>& seats) {

        if(seatIndexes.size() == 1){
            int seat = seatIndexes[0];
            return max(seat, (int)seats.size() - seat - 1);
        }

        int maxDifferenceHalf = 0;

        for (int i = 0; i < seatIndexes.size() - 1; ++i) {
            int before = seatIndexes[i], after = seatIndexes[i + 1];
            maxDifferenceHalf = max((after - before) / 2, maxDifferenceHalf);
        }

        int first = 0;
        for (int i = 0; i < seats.size(); ++i) {
            if(seats[i] != 0){
                first = i;
                break;
            }
        }

        int last = 0;

        for (int i = (int)seats.size() - 1; i >= 0; --i) {
            if(seats[i] != 0){
                last = i;
                break;
            }
        }

        return max(maxDifferenceHalf, max(first, (int)seats.size() - last - 1));
    }

    static bool is1(int i){
        return i == 1;
    }
};