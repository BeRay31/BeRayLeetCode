package beray.leetcode.AlgorithmStudiesII.Day2;
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedSortedArray {
  public int findMin(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < nums.length - 1 && right > 0) {
      if (nums[left] > nums[left+1]) return nums[left + 1];
      else left++;
      if (nums[right] < nums[right - 1]) return nums[right];
      else right--;
    }
    return nums[0];
  }
}
