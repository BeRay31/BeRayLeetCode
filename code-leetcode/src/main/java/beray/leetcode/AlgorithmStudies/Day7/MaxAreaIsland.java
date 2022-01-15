package beray.leetcode.AlgorithmStudies.Day7;
// https://leetcode.com/problems/max-area-of-island/
public class MaxAreaIsland {

  public static int[] dir = new int[]{0, 1, 0, -1, 0};

  public int countIsland(int[][] grid, int sr, int sc) {
    if (sr < 0 || sc < 0 || sr >= grid.length || sc >= grid[sr].length || grid[sr][sc] != 1) return 0;
    int count = 1;
    grid[sr][sc] = -1;
    for (int i = 0; i < dir.length - 1; i++) count += countIsland(grid, sr + dir[i], sc + dir[i + 1]);
    return count;
  }

  public int maxAreaOfIsland(int[][] grid) {
    int max = 0;
    for (int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 1) {
          max = Math.max(max, countIsland(grid, i, j));
        }
      }
    }
    return max;
  }
}
