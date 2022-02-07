#include "vector"
using namespace std;

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int originalBoard[board.size()][board[0].size()];

        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[0].size(); ++j) {

                int liveNeighbors = 0;
                for (int di = -1; di <= 1; ++di) {
                    for (int dj = -1; dj <= 1; ++dj) {
                        if(di == dj && dj == 0){
                            continue;
                        }

                        int x = i + di;
                        int y = j + dj;

                        if(boundaryValid(x,y, board.size(), board[0].size())){
                            liveNeighbors += board[x][y];
                        }
                    }
                }

                if(board[i][j] == 1){
                    if(liveNeighbors < 2 || liveNeighbors > 3){
                        originalBoard[i][j] = 0;
                    } else{
                        originalBoard[i][j] = 1;
                    }
                }else{
                    if(liveNeighbors == 3){
                        originalBoard[i][j] = 1;
                    }else{
                        originalBoard[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < board.size(); ++i) {
            for (int j = 0; j < board[0].size(); ++j) {
                board[i][j] = originalBoard[i][j];
            }
        }

    }

    static inline bool boundaryValid(int x, int y, int size,int size0){
        return 0 <= x && x < size && 0 <= y && y < size0;
    }
};