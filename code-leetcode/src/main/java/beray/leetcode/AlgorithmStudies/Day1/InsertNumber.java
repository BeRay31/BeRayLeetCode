package beray.leetcode.AlgorithmStudies.Day1;
// https://leetcode.com/problems/search-insert-position/
public class InsertNumber {
  // O (log n)
  public int binaryInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    
    while (left <= right) {
      int mid = left + (right - left)/2;

      if (nums[mid] > target) right = mid - 1;
      else if (nums[mid] < target) left = mid + 1;
      else return mid;
    }
    return left;
  }

  // O (n)
  public int sequentialInsert(int[] nums, int target) {
    if (nums.length == 0) return 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] >= target) {
        return i;
      }
    }
    return nums.length;
  }
}


