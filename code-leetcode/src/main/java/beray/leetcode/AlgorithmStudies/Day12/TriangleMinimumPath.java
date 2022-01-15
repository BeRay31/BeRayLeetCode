package beray.leetcode.AlgorithmStudies.Day12;

import java.util.List;
// https://leetcode.com/problems/triangle/
public class TriangleMinimumPath {
  public int minimumTotal(List<List<Integer>> triangle) { // Bottom Up Approach
    int m = triangle.size();
    int n = triangle.get(m - 1).size();
    if (m == 0) return 0;
    else if (m == 1) return triangle.get(0).get(0);

    int[][] memo = new int[2][n];
    memo[0][0] = triangle.get(0).get(0);
    int min = Integer.MAX_VALUE;

    for (int i = 1; i < m; i++) {
      memo[1][0] = Integer.MAX_VALUE;
      List<Integer> currTri = triangle.get(i);
      for (int j = 0; j < i; j++) {
        memo[1][j] = Math.min(memo[1][j], memo[0][j] + currTri.get(j));
        memo[1][j+1] = memo[0][j] + currTri.get(j + 1);
        if (i == m - 1) min = Math.min(memo[1][j], memo[1][j+1]);
      }
      memo[0] = memo[1];
      memo[1] = new int[n];
      for(int j = 0; j < memo[0].length; j++) System.out.print(memo[0][j]);
      System.out.println();
    }

    return min;
  }
}
