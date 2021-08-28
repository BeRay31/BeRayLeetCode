// https://leetcode.com/problems/rotate-array/
// IDEA, [1,2,3,4,5,6,7], k = 3 -> reverse (0, 3), reverse (4, 6) -> [4,3,2,1,7,6,5] -> reverse(0, 6) -> [5,6,7,1,2,3,4]
// [1,2,3,4], k = 2. factor must be handled first, check if it is exceed the array len or not, simplest way to handle this is by modulo operation

public class ScrollArray {
  public void reverse(int[] nums, int start, int end) {
    while(start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  public void rotate(int[] nums, int factor) {
    if (nums.length < 2) return;
    int k = factor % nums.length;
    reverse(nums, 0, nums.length - factor);
    reverse(nums, factor + 1, nums.length - 1);
    reverse(nums, 0, nums.length - 1);
  }
}
