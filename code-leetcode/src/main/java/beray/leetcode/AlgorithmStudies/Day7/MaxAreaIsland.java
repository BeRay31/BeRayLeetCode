package beray.leetcode.AlgorithmStudies.Day7;
// https://leetcode.com/problems/max-area-of-island/
public class MaxAreaIsland {

  public int maxAreaOfIsland(int[][] grid) {
    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          max = Math.max(max, floodFillCounter(grid, i, j, grid[i][j]));
        }
      }
    }
    return max;
  }

  public int floodFillCounter(int[][] grid, int r, int c, int val) {
    if (r < 0 || c < 0 || r >= grid.length || c >=grid[0].length || grid[r][c] != val) return 0;
    grid[r][c] = -1;
    return 1 + floodFillCounter(grid, r - 1, c, val) + floodFillCounter(grid, r, c - 1, val) + floodFillCounter(grid, r + 1, c, val) + floodFillCounter(grid, r, c + 1, val);
  }
}
