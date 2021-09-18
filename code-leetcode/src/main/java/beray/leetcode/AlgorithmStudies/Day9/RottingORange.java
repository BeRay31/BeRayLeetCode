package beray.leetcode.AlgorithmStudies.Day9;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/
public class RottingORange {
  public int orangesRottingBFS(int[][] grid) {
    Queue<int[]> q = new LinkedList<>();
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    // search the rotting orange and put in on the queue, and its possible to have more than 1 rotten orange and also evaluate all fresh orange
    int r = grid.length;
    int c = grid[0].length;
    int freshOrangesCount = 0;
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (grid[i][j] == 2) {
          q.offer(new int[]{i,j,0}); // first two are position, and third are depth level
        } else if (grid[i][j] == 1) {
          freshOrangesCount++;
        }
      }
    }

    int lastLevel = 0;
    if (freshOrangesCount == 0) return 0;
    while(q.peek() != null) {
      int[] curr = q.poll();
      for (int[] dir: dirs) {
        int row = curr[0] + dir[0];
        int col = curr[1] + dir[1];
        if (row < 0 || col < 0 || row >= r || col >= c || grid[row][col] == 0 || grid[row][col] == 2) continue;
        grid[row][col] = 2;
        int newLevel = curr[2] + 1;
        freshOrangesCount--;
        q.offer(new int[]{row, col, newLevel});
        if (lastLevel < newLevel) lastLevel = newLevel;
      }
    }
    if (freshOrangesCount > 0) return -1;
    else return lastLevel;
  }
}
