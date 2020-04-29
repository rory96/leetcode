package com.keanu.algorithm.leetcode.medium;

/**
 * 200 - medium - 岛屿数量
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length, num = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(grid, i, j);
                }
            }
        }
        return num;
    }
    private void dfs(char[][] grid, int m, int n) {
        if (!inArea(grid, m, n)) return;
        if (grid[m][n] != '1') return;
        grid[m][n] = '2'; // 标记已经访问过
        dfs(grid, m - 1, n);
        dfs(grid, m + 1, n);
        dfs(grid, m, n - 1);
        dfs(grid, m, n + 1);
    }
    private boolean inArea(char[][] grid, int m, int n) {
        return m >= 0 && n >= 0 && m < grid.length && n < grid[0].length;
    }
}
