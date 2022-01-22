package beray.leetcode.AlgorithmStudiesII.Day2;
// https://leetcode.com/problems/find-peak-element/
public class FindPeakIndex {
  public int findPeakElement(int[] nums) {
    if (nums.length == 1) return 0;
    else if (nums.length == 2) return nums[0] > nums[1] ? 0 : 1;
    int left = 1;
    int right = nums.length - 2;
    while (left < nums.length - 1 && right > 0) {
      if (nums[left - 1] < nums[left] && nums[left] > nums[left + 1]) return left;
      else left++;
      if (nums[right - 1] < nums[right] && nums[right] > nums[right + 1]) return right;
      else right--;
    }
    return nums[0] < nums[1] ? nums.length - 1 : 0;
  }
}
