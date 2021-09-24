package beray.leetcode.AlgorithmStudies.Day12;
// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
  public int climbHelpers (int n, int[] memo) {
    if (n > 0) {
      if (memo[n] != 0) {
        return memo[n];
      } else {
        int res = climbHelpers(n - 1, memo);
        memo[n-1] = res;
        if (n >= 2) {
          int res2 = climbHelpers(n - 2, memo);
          memo[n-2] = res2;
          res += res2;
        }
        memo[n] = res;
        return memo[n];
      }
    }
    return memo[n];
  }

  public int climbStairs(int n) {
    int[] memo = new int[n + 1];
    memo[0] = 1;
    return climbHelpers(n, memo);
  }

  public int climbStairsRecursive(int n) {
    if (n != 0) {
      int res = climbStairsRecursive(n - 1);
      if (n > 1) {
        res += climbStairsRecursive(n - 2);
      } 
      return res;
    } return 1;
  }
}
