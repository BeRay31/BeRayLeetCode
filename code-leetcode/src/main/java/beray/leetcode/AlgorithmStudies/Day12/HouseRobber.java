package beray.leetcode.AlgorithmStudies.Day12;
// https://leetcode.com/problems/house-robber/
public class HouseRobber {
  public int robHelper(int[] nums, int index, boolean isPrevTaken, int rob, int[] memo) {
    if (index < nums.length) {
      if (isPrevTaken) {
        return robHelper(nums, index + 1, false, rob, memo);
      } else {
        if (memo[index] != -1) {
          return rob + memo[index];
        } else {
          int res = Math.max(robHelper(nums, index + 1, true, nums[index], memo), robHelper(nums, index + 1, false, 0, memo));
          memo[index] = res;
          return rob + memo[index];
        }
      }
    } else {
      return rob;
    }
  }
  
  public int rob(int[] nums) {
    if (nums.length < 1) return 0;
    int[] memo = new int[nums.length];
    for(int i = 0; i < memo.length; i++) {
      memo[i] = -1;
    }
    return robHelper(nums, 0, false, 0, memo);
  }
}
