package beray.leetcode.AlgorithmStudiesII.Day1;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindRangePositionTargetArray {
  public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) return new int[]{-1,-1};
    int left = 0;
    int right = nums.length - 1;
    int foundIndex = -1;
    while (left <= right) {
      int mid = left + (right - left)/2;
      if (nums[mid] == target) {
        foundIndex = mid;
        break;
      } else if (nums[mid] > target) right = mid - 1;
      else if (nums[mid] < target) left = mid + 1;
    }
    if (foundIndex == -1) return new int[]{-1, -1};
    boolean leftBreak = false, rightBreak = false;
    left = foundIndex;
    right = foundIndex;
    while (!leftBreak || !rightBreak) {
      if (left > 0) {
        if (nums[left - 1] == target) left--;
        else leftBreak = true;
      } else leftBreak = true;

      if (right < nums.length - 1) {
        if(nums[right + 1] == target) right++;
        else rightBreak = true;
      } else rightBreak = true;
    }
    return new int[]{left, right};
  }
}
