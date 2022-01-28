package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[] shifted = new int[grid.length * grid[0].length];
        k %= shifted.length;
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, shifted, i * grid[0].length, grid[0].length);
        }
        int[] clone = new int[shifted.length];
        for (int i = 0; i < shifted.length; i++){
            clone[(i + k) % shifted.length] = shifted[i];
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                sub.add(clone[i * grid[0].length +j]);
            }
            result.add(sub);
        }

        return result;
    }
}
