package beray.leetcode.AlgorithmStudiesII.Day1;
// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
  public int search(int[] nums, int target) {
    int n = nums.length;

    if (n == 1) return nums[0] == target ? 0 : -1;
    int left = 0;
    int right = n - 1;

    int start = 0;

    while (left < n - 1 || right > 0) {
      if (nums[left] > nums[left + 1]) {
        start = left + 1;
        break;
      } else left++;

      if (nums[right] < nums[right - 1]) {
        start = right;
        break;
      } else right--;
    }

    left = start;
    right = (start - 1 + n) % n;

    while (((left - start + n) % n) <= ((right - start + n) % n)) {

      int mid = (left + (right - left)/2 + n) % n; // Simplify

      if ((mid == left || mid == right) && left == right) return nums[mid] == target ? mid : -1;
      else if (nums[mid] > target) right = (mid - 1 + n) % n;
      else if (nums[mid] < target) left = (mid + 1 + n) % n;
      else return mid;
    }
    return -1;
  }
}