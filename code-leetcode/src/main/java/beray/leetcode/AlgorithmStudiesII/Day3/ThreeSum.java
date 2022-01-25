package beray.leetcode.AlgorithmStudiesII.Day3;
// https://leetcode.com/problems/3sum/
import java.util.*;
public class ThreeSum {
  public List<List<Integer>> threeSum(int[] nums) {
    int n = nums.length;
    if (n < 3) return new ArrayList<>();
    // sort
    Arrays.sort(nums);
    List<List<Integer>> sol = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int fp = nums[i];
      int left = i + 1;
      int right = n - 1;
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      if (left + 1 < n && fp + nums[left] + nums[left + 1] > 0) continue;
      while (left < right && left < n && right >= 0) {
        int sum = fp + nums[left] + nums[right];
        if (sum > 0 || (right < n - 1 && nums[right] == nums[right+1])) right--;
        else if (sum < 0 || (left > i + 1 && nums[left] == nums[left-1])) left++;
        else {
          sol.add(new ArrayList<Integer>(Arrays.asList(fp, nums[left], nums[right])));
          right--;
          left++;
        }
      }
    }
    return sol;
  }
}
