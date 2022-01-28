package beray.leetcode.AlgorithmStudiesII.Day6;
// https://leetcode.com/problems/number-of-islands/
public class NumberOfIsland {
  int[] dir = new int[]{1, 0, -1, 0, 1};
  public void exploreIsland(char[][] grid, boolean[][] visited, int row, int col) {
    if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || visited[row][col]) return;
    visited[row][col] = true;
    if (grid[row][col] != '1') return;
    for (int i = 0; i < dir.length - 1; i++) {
      exploreIsland(grid, visited, row + dir[i], col + dir[i+1]);
    }
  }

  public int numIslandsDFS(char[][] grid) {
    int m = grid.length;
    boolean[][] visited = new boolean[m][300];
    int count = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (visited[i][j]) continue;
        else {
          if (grid[i][j] == '1') {
            count++;
            exploreIsland(grid, visited, i, j);
          } else visited[i][j] = true;
        }
      }
    }
    return count;
  }
}
