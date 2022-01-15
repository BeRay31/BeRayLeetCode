package beray.leetcode.AlgorithmStudies.Day12;
// https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {
  public int helper(int n, int[] memo) {
    if (memo[n] != 0) return memo[n];
    else {
      memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
      return memo[n];
    }
  }

  public int climbStairs(int n) {
    int[] memo = new int[n];
    memo[0] = 1;
    memo[1] = 1;
    return helper(n, memo);
  }
}
