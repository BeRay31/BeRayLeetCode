public class BinarySearch {
  public int recursiveHelper(int[] nums, int left, int right, int target) {
    int center = (left + right)/2;
    // base case
    if (right - left == 1) {
      if (nums[right] == target) {
        return right;
      } else if (nums[left] == target) {
        return left;
      } else {
        return -1;
      }
    }
    // recursive
    else if (nums[center] > target) {
      this.recursiveHelper(nums, left, center, target);
    } else if (nums[center] < target) {
      this.recursiveHelper(nums, center, right, target);
    } else {
      return center;
    }
  }

  public int recursiveSolution(int[] nums, int target) {
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
}
