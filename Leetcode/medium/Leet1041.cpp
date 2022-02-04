#include "string"

using namespace std;

class Solution {
public:
    bool isRobotBounded(string instructions) {
        int dirIndex = 0;
        int moves[4][2] = {{0,  1},
                           {-1, 0},
                           {0, -1},
                           {1, 0}};
        int x = 0, y = 0;
        for (char c: instructions) {
            switch (c) {
                case 'G': {
                    x += moves[dirIndex][0];
                    y += moves[dirIndex][1];
                    break;
                }

                case 'L': {
                    dirIndex = (dirIndex + 1) % 4;
                    break;
                }

                case 'R': {
                    dirIndex = (dirIndex - 1 + 4) % 4;
                }
            }
        }

        return (x == 0 && y == 0) || dirIndex != 0;
    }
};