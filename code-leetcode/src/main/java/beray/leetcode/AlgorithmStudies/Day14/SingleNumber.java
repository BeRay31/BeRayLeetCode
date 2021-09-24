package beray.leetcode.AlgorithmStudies.Day14;
// https://leetcode.com/problems/single-number/
// Bitwise XOR N ^ N = 0, 0 ^ N = N
public class SingleNumber {
  public int singleNumber(int[] nums) {
    int ans = 0;
    for (int i = 0; i < nums.length; i++) {
      ans ^= nums[i];
    }
    return ans;
  }
}
