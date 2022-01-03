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
    int n = nums.length;
    int[] newNums = new int[n];
    int idx = n - 1;
    int start = 0;
    int end = idx;
    while (idx >= 0) {
      int left = nums[start]*nums[start];
      int right = nums[end]*nums[end];
      if (left > right) {
        newNums[idx] = left;
        start++;
      } else {
        newNums[idx] = right;
        end--;
      }
      idx--;
    }
    return newNums;
  }
}
