package beray.leetcode.AlgorithmStudies.Day12;

import java.util.List;

// https://leetcode.com/problems/triangle/
public class TriangleMinimumPath {
  public int minimumHelper(List<List<Integer>> triangle, int sum, int index, int nestIndex, int[] memo) {
    if (index < triangle.size()) {
      if (memo[index] != 0) {
        return sum + memo[index];
      } else {
        int newSum = triangle.get(index).get(nestIndex);
        int res = Math.min(minimumHelper(triangle, newSum, index + 1, nestIndex, memo), minimumHelper(triangle, newSum, index + 1, nestIndex + 1, memo));
        memo[index] = res;
        return sum + memo[index];
      }
    } else {
      return sum;
    }
  }

  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle.size() > 1) {
      int[] memo = new int[triangle.size() + 1];
      return minimumHelper(triangle, 0, 0, 0, memo);
    } return triangle.get(0).get(0);
  }
}
