package beray.leetcode.AlgorithmStudies.Day9;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/
public class RottingORange {
  int[] dir = new int[]{0, 1, 0, -1, 0};

  public int orangesRotting(int[][] grid) {
    int fresh = 0;
    int m = grid.length;
    int n = grid[0].length;

    Queue<int[]> q = new LinkedList<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) fresh++;
        else if (grid[i][j] == 2) q.add(new int[]{i, j, 0});
      }
    }

    int level = 0;

    while(!q.isEmpty()) {
      int[] curLoc = q.poll();
      level = Math.max(level, curLoc[2]);
      for (int i = 0; i < dir.length - 1; i++) {
        int row = curLoc[0] + dir[i];
        int col = curLoc[1] + dir[i+1];
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] != 1) continue;
        grid[row][col] = 2;
        fresh--;
        q.add(new int[]{row, col, curLoc[2] + 1});
      }

    }

    if (fresh != 0) return -1;
    return level;
  }
}
