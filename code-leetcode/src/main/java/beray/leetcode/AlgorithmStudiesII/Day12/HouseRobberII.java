package beray.leetcode.AlgorithmStudiesII.Day12;
// /https://leetcode.com/problems/house-robber-ii/
public class HouseRobberII {
  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    if (nums.length == 2) return Math.max(nums[0], nums[1]);
    int[][] memo = new int[nums.length][2];
    int[][] memo2 = new int[nums.length][2];
    memo[0][0] = 0;
    memo[0][1] = nums[0];
    memo2[1][0] = 0;
    memo2[1][1] = nums[1];
    for (int i = 1; i < nums.length - 1; i++) {
      memo[i][0] = Math.max(memo[i-1][0], memo[i-1][1]);
      memo[i][1] = memo[i-1][0] + nums[i];
    }
    for (int i = 2; i < nums.length; i++) {
      memo2[i][0] = Math.max(memo2[i-1][0], memo2[i-1][1]);
      memo2[i][1] = memo2[i-1][0] + nums[i];
    }
    return Math.max(memo[nums.length - 2][0], Math.max(memo[nums.length - 2][1], Math.max(memo2[nums.length - 1][0], memo2[nums.length - 1][1])));
  }
}
