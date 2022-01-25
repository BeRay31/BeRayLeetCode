package beray.leetcode.AlgorithmStudiesII.Day5;
// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubArraySum {
  public int minSubArrayLenPrefixSum(int target, int[] nums) {
    if (nums.length == 1) return nums[0] >= target ? 1 : 0;
    int[] prefixSum = new int[nums.length];
    // Build prefix sum
    prefixSum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) prefixSum[i] = prefixSum[i - 1] + nums[i];
    if (target > prefixSum[nums.length - 1]) return 0;
    int right = nums.length - 1;
    int min = Integer.MAX_VALUE;
    while (right >= 0) {
      int sp = right - 1;
      if (prefixSum[right] >= target) min = Math.min(right + 1, min);
      while (sp > 0 && prefixSum[right] - prefixSum[sp] < target) sp--;
      if (prefixSum[right] - prefixSum[sp] >= target) min = Math.min(right - sp, min);
      right--;
    }
    return min;
  }
  
  public int minSubArrayLenSlidin(int target, int[] nums) {
    if (nums.length == 1) return nums[0] >= target ? 1 : 0;
    int left = 0;
    int right = 0;
    int sum = 0;
    int min = Integer.MAX_VALUE;

    while (right < nums.length) {
      sum += nums[right++];
      while (sum >= target) {
        min = Math.min(right - left, min);
        sum -= nums[left++];
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }
}
