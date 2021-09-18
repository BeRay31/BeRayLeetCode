package beray.leetcode.AlgorithmStudies.Day9;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/01-matrix/
public class BinaryMatrix {
  public int[][] updateMatrixBFS(int[][] matrix) {
    // Init queue
    Queue<int[]> queue = new LinkedList<>();
    int m = matrix.length;
    int n = matrix[0].length;
    // Visited Arr
    boolean[][] visited = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          // set 0 as it distance by tag it as an evaluated item and append it to queue cuz 0 is the base
          queue.offer(new int[]{i, j});
          visited[i][j] = true;
        }
      }
    }
    // dir array
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    // The idea is create an array of distance from an array that has value 0, since it is BFS then it will construct the array of minimum distance
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      for (int i = 0; i < 4; i++) {
        int row = cur[0] + dir[i][0];
        int col = cur[1] + dir[i][1];
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) continue;
        visited[row][col] = true;
        matrix[row][col] = matrix[cur[0]][cur[1]] + 1;
        queue.offer(new int[]{row, col});
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