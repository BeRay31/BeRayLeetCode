package beray.leetcode.AlgorithmStudies.Day1;
// https://leetcode.com/problems/binary-search/
// 2 Solution used => Recursive and sequential
public class BinarySearch {
  public int recursiveHelper(int[] nums, int left, int right, int target) {
    int center = left + (right - left)/2;
    if ((center == right && nums[center] != target) || left > right) return -1;
    else if (nums[center] > target) {
      return this.recursiveHelper(nums, left, center - 1, target);
    } else if (nums[center] < target) {
      return this.recursiveHelper(nums, center + 1, right, target);
    } else return center;
  }

  public int recursiveSolution(int[] nums, int target) { // kinda dumb but just in case needed to be recursive this is the solution
    return this.recursiveHelper(nums, 0, nums.length - 1, target);
  }

  public int sequentialBinarySearch(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right)/2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1; 
      } else if (nums[mid] < target) {
        left = mid + 1;
      }
    }
    return -1;
  }

  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;
    
    while (left <= right) {
      int mid = left + (right - left)/2;
      if (nums[mid] > target) right = mid - 1;
      else if (nums[mid] < target) left = mid + 1;
      else return mid;
    }
    return -1;
  }
}
