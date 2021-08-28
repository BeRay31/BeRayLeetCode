import java.time.temporal.Temporal;

public class MoveZeros {
  // this will work even when the number is not only zero but whitelisted in some array
  public void TwoPointerSolution(int[] nums) {
    int zeroPointer = nums.length - 1;
    int iterationPointer = 0;
    while(iterationPointer < nums.length) {
      if (nums[iterationPointer] == 0) {
        nums[iterationPointer] = nums[zeroPointer];
        nums[zeroPointer] = 0;
        zeroPointer--;
        scrollTo(nums, iterationPointer, zeroPointer, zeroPointer - iterationPointer);
        iterationPointer--;
      }
      iterationPointer++;
    }
  }

  public void reverse(int[] nums, int start, int end) {
    if (start == end) return;
    while(start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  public void scrollTo(int[] nums, int start, int end, int factor) {
    int subArrayLen = end - start + 1;
    if (subArrayLen < 2) return;
    int k = factor % subArrayLen;
    reverse(nums, start, end - k);
    reverse(nums, end - k + 1, end);
    reverse(nums, start, end);
  }

  // shift solution (work when the target isn't an array but specific number)
  public void shiftZero (int[] nums) {
    int k = 0;
    int countZero = 0;
    for (int val: nums) {
      if(val != 0) nums[k++] = val;
      else countZero++;
    }
    for (int idx = nums.length - countZero + 1; idx < nums.length; idx++) {
      nums[idx] = 0;
    }
  }

  // https://leetcode.com/problems/move-zeroes/discuss/172432/THE-EASIEST-but-UNUSUAL-snowball-JAVA-solution-BEATS-100-(O(n))-%2B-clear-explanation
  // SNOWBALL ALGO (improving 2 solution above)
  public void snowball(int[] nums) {
    if (nums.length < 2) return;
    int snowballCount = 0;
    int snowballFirst = -1;
    int iter = 0;
    while(iter < nums.length) {
      if (nums[iter] == 0) { // manipulate the conditional to make this function act with some list
        snowballFirst = iter - snowballCount;
        snowballCount++;
      } else {
        if (snowballFirst != -1) {
          int temp = nums[snowballFirst];
          nums[snowballFirst] = nums[iter];
          nums[iter] = temp;
          snowballFirst++;
        }
      }
      iter++;
    }
  }

  public void improvedSnowball(int[] nums) {
    if (nums.length < 2) return;
    int curr = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        int temp = nums[curr];
        nums[curr++] = nums[i];
        nums[i] = temp;
      }
    }
  }
}
