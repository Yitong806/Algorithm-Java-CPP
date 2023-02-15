package leetcode.medium;

import java.util.Arrays;

public class Leet1219 {

    int maximumGold = 0;
    int currentGold = 0;
    boolean[][] visited;

    public void clean() {
        for (boolean[] vs : visited) {
            Arrays.fill(vs, false);
        }
        currentGold = 0;
    }

    public boolean outBound(int x, int y){
        return x < 0 || x >= visited.length || y < 0 || y >= visited[0].length;
    }

    public void dfs(int i, int j, int[][] grid) {
        currentGold += grid[i][j];
        maximumGold = Math.max(maximumGold, currentGold);
        visited[i][j] = true;
        int[][] directionArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir: directionArray){
            int x = i + dir[0], y = j + dir[1];
            if(outBound(x, y)){
                continue;
            }

            if(visited[x][y]){
                continue;
            }

            if(grid[x][y] == 0){
                continue;
            }

            int tempGoldSave = currentGold;
            dfs(x, y, grid);
            currentGold = tempGoldSave;
        }
        visited[i][j] = false;
        currentGold -= grid[i][j];
    }

    public int getMaximumGold(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 0){
                    continue;
                }

                clean();
                dfs(i,j, grid);
            }
        }

        return maximumGold;
    }
}
