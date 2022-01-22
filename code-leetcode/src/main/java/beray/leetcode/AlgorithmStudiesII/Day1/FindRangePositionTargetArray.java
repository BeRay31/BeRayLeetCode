package beray.leetcode.AlgorithmStudiesII.Day1;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindRangePositionTargetArray {
  public int[] searchRange(int[] nums, int target) {
    int n = nums.length;
    if (n == 0) return new int[]{-1, -1};

    int left = 0;
    int right = n - 1;

    while (left <= right) {
      int mid = left + (right - left)/2;
      if (nums[mid] > target) right = mid - 1;
      else if (nums[mid] < target) left = mid + 1;
      else {
        int fr = mid;
        int lr = mid;
        boolean leftBreak = false;
        boolean rightBreak = false;
        while (true) {
          if (fr > 0 && nums[fr-1] == target) fr--;
          else leftBreak = true;
          
          if (lr < n - 1 && nums[lr + 1] == target) lr++;
          else rightBreak = true;

          if (leftBreak && rightBreak) break;
        }

        return new int[]{fr, lr};
      }
    }
    return new int[]{-1, -1};
  }
}
