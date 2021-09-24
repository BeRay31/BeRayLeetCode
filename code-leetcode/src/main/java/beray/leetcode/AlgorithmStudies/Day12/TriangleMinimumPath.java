package beray.leetcode.AlgorithmStudies.Day12;

import java.util.Arrays;
import java.util.List;
// https://leetcode.com/problems/triangle/
public class TriangleMinimumPath {
  public int minimumHelper(List<List<Integer>> triangle, int index, int nestIndex, int[][] memo) {
    if (index < triangle.size()) {
      if (memo[index][nestIndex] != -1) return memo[index][nestIndex];
      else {
        int rootVal = triangle.get(index).get(nestIndex);
        if (index + 1 < triangle.size()) {
          int left = minimumHelper(triangle, index + 1, nestIndex, memo);
          if (memo[index + 1][nestIndex] != -1) memo[index + 1][nestIndex] = Math.min(left, memo[index + 1][nestIndex]);
          int right = minimumHelper(triangle, index + 1, nestIndex + 1, memo);
          if (memo[index + 1][nestIndex + 1] != -1) memo[index + 1][nestIndex + 1] = Math.min(right, memo[index + 1][nestIndex + 1]);
          memo[index][nestIndex] = rootVal + Math.min(memo[index + 1][nestIndex], memo[index + 1][nestIndex + 1]);
        } else {
          memo[index][nestIndex] = rootVal;
        }
        return memo[index][nestIndex];
      } 
    } return 0;
  }

  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle.size() > 1) {
      int[][] memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
      for (int[] arr: memo) {
        Arrays.fill(arr, -1);
      }
      return minimumHelper(triangle, 0, 0, memo);
    } return triangle.get(0).get(0);
  }
}
