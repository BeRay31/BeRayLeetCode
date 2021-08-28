package beray.leetcode.AlgorithmStudies.Day2;
// https://leetcode.com/problems/squares-of-a-sorted-array/
// Solution => Using 2 pointers manipulation
public class SquaresOfASortedArrays {
  public int abs(int val) {
    return val < 0 ? -val : val;
  }

  public int square(int val) {
    return val * val;
  }

  public int[] twoPointer(int[] nums) {
    int[] newSortedNums = new int[nums.length];
    int left = 0;
    int right = nums.length - 1;
    int currentIdx = nums.length - 1;
    
    while(left <= right && currentIdx >= 0) {
      if (this.abs(nums[left]) > this.abs(nums[right])) {
        newSortedNums[currentIdx] = this.square(nums[left]);
        left++;
      } else {
        newSortedNums[currentIdx] = this.square(nums[right]);
        right--;
      }
      currentIdx--;
    }
    return newSortedNums;
  }
}
