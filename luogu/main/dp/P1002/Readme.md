# Explanation to P1002 in Luogu

### 过河卒
难度：普及-   
要求：给定一个只有一个可移动卒和一个固定马棋子的棋盘，其中卒从最左上角的位置开始移动，只能向下或者向右走，并且无法移动到马棋子本身及其所控制的方格。询问卒子从左上角移动到右下角可以移动的方案总数。    
方法：动态规划
##### 其中状态转移方程是：   
  
chessboard[i][j] =   
1. 0 if (i,j) can be attacked by horse;  
2. 1 if (i,j) is located at the boundary of chessboard;  
3. chessboard[i][j-1]+ chessboard[i-1][j] otherwise;     
   
注意：初始化边线时，如果有位置遇到可以被马棋子攻击，那么后续的初始化就都会变为0(因为被马截断了去路，无法到达边线上的后续格子)  
