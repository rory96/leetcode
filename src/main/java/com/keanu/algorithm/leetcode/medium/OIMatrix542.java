package com.keanu.algorithm.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 542 - medium
 */
public class OIMatrix542 {
    public static int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] direction = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        while (!queue.isEmpty()) {
            int[] zero = queue.poll();
            for (int k = 0; k < 4; k++) {
                int m = zero[0] + direction[k][0];
                int n = zero[1] + direction[k][1];
                if (m >= row || n >= col || m < 0 || n < 0 || visited[m][n]) continue;
                visited[m][n] = true;
                matrix[m][n] = matrix[zero[0]][zero[1]] + 1;
                queue.offer(new int[]{m, n});
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        matrix = updateMatrix(matrix);
        System.out.println(Arrays.toString(matrix[0]));
        System.out.println(Arrays.toString(matrix[1]));
        System.out.println(Arrays.toString(matrix[2]));
    }
}