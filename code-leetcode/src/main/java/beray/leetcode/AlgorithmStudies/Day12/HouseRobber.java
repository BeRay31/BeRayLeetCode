package beray.leetcode.AlgorithmStudies.Day12;
// https://leetcode.com/problems/house-robber/
public class HouseRobber {
  public int rob(int[] nums) { // Bottom up approach
    int[][] memo = new int[nums.length][2];
    memo[0][1] = nums[0]; 
    for(int i = 1; i < nums.length; i++) {
      memo[i][0] = Math.max(memo[i-1][0], memo[i-1][1]);
      memo[i][1] = memo[i - 1][0] + nums[i];
    }
    return Math.max(memo[nums.length - 1][0], memo[nums.length-1][1]);
  }

  public int helper(int[][] memo, int[] nums, int index, int isTaken) {
    if (memo[index][isTaken] != -1) return memo[index][isTaken];
    else {
      if (isTaken == 1) memo[index][isTaken] = helper(memo, nums, index - 1, 0) + nums[index];
      else memo[index][isTaken] = Math.max(helper(memo, nums, index - 1, 0), helper(memo, nums, index - 1, 1));
    }
    return memo[index][isTaken];
  }

  public int robTopDown(int[] nums) {
    int[][] memo = new int[nums.length][2];
    for(int i = 0; i < nums.length; i++) {
      memo[i][1] = -1;
      memo[i][0] = -1;
    }
    memo[0][1] = nums[0];
    memo[0][0] = 0;
    return Math.max(helper(memo, nums, nums.length - 1, 1), helper(memo, nums, nums.length - 1, 0));
  }
}
