package beray.leetcode.AlgorithmStudiesII.Day8;

import java.util.LinkedList;
import java.util.Queue;
// https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class BinaryMatrixShortestPath {
  int[] dir = new int[]{0, 1, 0, -1, 0};
  int[] dig = new int[]{1, -1, -1, 1, 1};
  // assuming 0,0 = 0 && n-1, n-1 = 0
  public int shortestPathBinaryMatrix(int[][] grid) {
    if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) return -1;
    int pathCount = Integer.MAX_VALUE;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{0,0,1});
    grid[0][0] = -1;
    while (!q.isEmpty()) {
      int[] curr = q.poll();
      grid[curr[0]][curr[1]] = -1;
      if (curr[0] == grid.length - 1 && curr[1] == grid.length - 1) pathCount = Math.min(pathCount, curr[2]);
      else {
        for (int i = 0; i < dir.length - 1; i++) {
          int newRow = curr[0] + dir[i];
          int newCol = curr[1] + dir[i+1];
          int newLvl = curr[2] + 1;
          if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid.length && grid[newRow][newCol] == 0) {
            q.add(new int[]{newRow, newCol, newLvl});
            grid[newRow][newCol] = -1; // made a mistake here, I was marked the tile as visited when evaluating, this will lead infinite loop because it might added twice or even more by the other tile since its 8 degree
          }
        }
        for (int i = 0; i < dig.length - 1; i++) {
          int newRow = curr[0] + dig[i];
          int newCol = curr[1] + dig[i+1];
          int newLvl = curr[2] + 1;
          if (newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid.length && grid[newRow][newCol] == 0) {
            q.add(new int[]{newRow, newCol, newLvl});
            grid[newRow][newCol] = -1;
          }
        }
      }
    }
    return pathCount == Integer.MAX_VALUE ? -1 : pathCount;     
  }
}
