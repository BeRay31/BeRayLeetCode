package beray.leetcode.AlgorithmStudies.Day2;
// https://leetcode.com/problems/rotate-array/
// IDEA, [1,2,3,4,5,6,7], k = 3 -> reverse (0, 3), reverse (4, 6) -> [4,3,2,1,7,6,5] -> reverse(0, 6) -> [5,6,7,1,2,3,4]
// [1,2,3,4], k = 2. factor must be handled first, check if it is exceed the array len or not, simplest way to handle this is by modulo operation
// Can be used to implement infinite carouel

public class ScrollArray {
  public static void reverse(int[] nums, int start, int end) {
    while(start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  public static void rotate(int[] nums, int factor) {
    if (nums.length < 2) return;
    int start = 0;
    int end = nums.length - 1;
    reverse(nums, start, end - factor);
    reverse(nums, end - factor + 1, end);
    reverse(nums, start, end);
  }

  public static void main(String[] args) {
    int[] testcase = new int[]{1,2,3,4,5,6};
    ScrollArray.rotate(testcase, 3);
    System.out.print("|");
    for(int i: testcase) {
      System.out.print(i + "|");
    }
  }

}