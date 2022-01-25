package beray.leetcode.AlgorithmStudiesII.Day5;
// https://leetcode.com/problems/subarray-product-less-than-k/
public class NumOfContiguousSubArray {
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (nums.length == 0) return 0;
    int numSubArr = 0;
    for (int i = 0; i < nums.length; i++) {
      int left = i;
      int right = i + 1;
      if (nums[left] < k) {
        numSubArr++;
        int mult = nums[left];
        while (right < nums.length) {
          mult *= nums[right];
          if (mult < k) numSubArr++;
          else break;
          right++;
        }
      } else continue;
    }
    return numSubArr;
  }
  // https://leetcode.com/problems/subarray-product-less-than-k/discuss/108861/JavaC%2B%2B-Clean-Code-with-Explanation
  public int numSubarrayProductLessThanKSliding(int[] nums, int k) {
    if (nums.length == 0) return 0;
    int numSubArr = 0;
    int left = 0;
    int right = 0;
    int mult = 1;
    while (right < nums.length && left <= right) {
      mult *= nums[right];
      while (mult > k) {
        mult /= nums[left];
        left++;
      }
      numSubArr += right - left + 1; // tricky part
      right++;
    }
    return numSubArr;
  }
}
