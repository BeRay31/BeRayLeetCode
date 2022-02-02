package beray.leetcode.AlgorithmStudiesII.Day13;
// https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {
  public int jump(int[] nums) {
    int[] memo = new int[nums.length];
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
        memo[j] = memo[j] == 0 ? memo[i] + 1 : Math.min(memo[j], memo[i] + 1);
      }
    }
    return memo[nums.length - 1];
  }
}
