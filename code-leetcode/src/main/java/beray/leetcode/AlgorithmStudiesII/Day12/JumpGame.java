package beray.leetcode.AlgorithmStudiesII.Day12;
// https://leetcode.com/problems/jump-game/
public class JumpGame {
  public boolean canJumpO2n(int[] nums) {
    if (nums.length == 1) return true;
    int[] memo = new int[nums.length];
    memo[0] = nums[0];
    for (int i = 0; i < nums.length - 1; i++) {
      if (memo[i] == 0) continue;
      int currVal = nums[i];
      int altIndex = i + 1;
      while (currVal > 0) {
        if (altIndex > nums.length - 1) break;
        memo[altIndex] += currVal;
        altIndex++;
        currVal--;
      }
    }
    return memo[nums.length - 1] != 0;
  }

  public boolean canJumpOn(int[] nums) {
    int reachable = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > reachable) return false;
      reachable = Math.max(reachable, i + nums[i]);
    }
    return true;
  }
}
