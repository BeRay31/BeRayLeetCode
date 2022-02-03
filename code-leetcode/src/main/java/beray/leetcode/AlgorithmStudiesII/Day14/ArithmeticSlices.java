package beray.leetcode.AlgorithmStudiesII.Day14;
// https://leetcode.com/problems/arithmetic-slices/
public class ArithmeticSlices {
  public int numberOfArithmeticSlices(int[] nums) {
    int n = nums.length;
    if (n < 3) return 0;
    int count = 0;
    int[] memo = new int[n];
    for (int i = 2; i < n; i++) {
      if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
        if (memo[i - 1] != 0) memo[i] = memo[i - 1] + 1;
        else memo[i] = 1;
      }
      count += memo[i];
    }
    return count;
  }
}
