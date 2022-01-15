package beray.leetcode.AlgorithmStudies.Day9;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/01-matrix/
public class BinaryMatrix {
  int[] dir = new int[]{0, 1, 0, -1, 0};
  public int[][] updateMatrixBFS(int[][] matrix) {
    Queue<int[]> q = new LinkedList<>();
    int m = matrix.length;
    int n = matrix[0].length;

    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          q.add(new int[]{i, j});
          visited[i][j] = true;
        }
      }
    }

    while (!q.isEmpty()) {
      int[] loc = q.poll();

      for (int i = 0; i < dir.length - 1; i++) {
        int newLocX = loc[0] + dir[i];
        int newLocY = loc[1] + dir[i+1];
        if (newLocX < 0 || newLocY < 0 || newLocX >= m || newLocY >= n || visited[newLocX][newLocY]) continue;
        visited[newLocX][newLocY] = true;
        matrix[newLocX][newLocY] = matrix[loc[0]][loc[1]] + 1;
        q.add(new int[]{newLocX, newLocY});
      }
    }

    return matrix;
  }

  public int[][] updateMatrixDP(int[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) {
      return matrix;
    }
    int range = matrix.length * matrix[0].length;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] != 0) {
          int upCell = (i > 0) ? matrix[i - 1][j] : range;
          int leftCell = (j > 0) ? matrix[i][j - 1] : range;
          matrix[i][j] = Math.min(upCell, leftCell) + 1;
        }
      }
    }

    for (int i = matrix.length - 1; i >= 0; i--) {
      for (int j = matrix[0].length - 1; j >= 0; j--) {
        if (matrix[i][j] != 0) {
          int downCell = (i < matrix.length - 1) ? matrix[i + 1][j] : range;
          int rightCell = (j < matrix[0].length - 1) ? matrix[i][j + 1] : range;
          matrix[i][j] = Math.min(Math.min(downCell, rightCell) + 1, matrix[i][j]);
        }
      }
    }

    return matrix;
  }
}