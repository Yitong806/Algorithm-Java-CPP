#include "vector"
#include "iostream"
using namespace std;

class Solution {
public:
    bool terminate = false;

    vector<vector<char>> updateBoard(vector<vector<char>>& board, vector<int>& click) {
        if(board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] ='X';
            terminate = true;
        }

        if(terminate){
            return board;
        }

        if(board[click[0]][click[1]] == 'E'){
            int count = countMine(board, click);
            if(count != 0){
                board[click[0]][click[1]] = (char)('0' + count);
            }else{
                board[click[0]][click[1]] = 'B';

                for (int i = -1; i <= 1; ++i) {
                    for (int j = -1; j <= 1; ++j) {
                        if(i ==j && j == 0){
                            continue;
                        }

                        int x = click[0] + i, y = click[1] + j;

                        if(boundary(board.size(), board[0].size(), x , y)){
                            vector<int> cl = {x , y};
                            cout <<i <<" "<<j<<" " <<x << " "<< y << ": "<<board[x][y]<<endl;
                            updateBoard(board, cl);
                        }
                    }
                }
            }
        }

        return board;
    }

    static bool boundary(int a, int b, int x, int y){
        return 0 <= x && x < a && 0 <= y && y < b;
    }

    static int countMine(vector<vector<char>>& board,vector<int>& click){
        int mine = 0;
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if(i == j && j == 0){
                    continue;
                }

                int x = click[0] + i, y = click[1] + j;

                if(boundary(board.size(), board[0].size(), x , y)){
                    if(board[x][y] == 'M' || board[x][y] == 'X'){
                        mine++;
                    }
                }
            }
        }

        return mine;
    }
};