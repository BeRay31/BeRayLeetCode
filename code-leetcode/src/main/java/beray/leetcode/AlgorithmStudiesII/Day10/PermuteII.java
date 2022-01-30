package beray.leetcode.AlgorithmStudiesII.Day10;
// https://leetcode.com/problems/permutations-ii/
import java.util.*;
public class PermuteII {
  public void permute(int[] nums, List<List<Integer>> sol, List<Integer> temp, int mask) {
    if (temp.size() == nums.length) {
      sol.add(new ArrayList<>(temp));
      return;
    }
    int lastAdded = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; i++) {
      if (lastAdded == nums[i]) continue;
      if (((mask >> i) & 1) == 0) {
        lastAdded = nums[i];
        temp.add(nums[i]);
        mask = mask | (1 << i);
        permute(nums, sol, temp, mask);
        temp.remove(temp.size() - 1);
        mask = mask ^ (1 << i);
      }
    }
  }
  
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> sol = new ArrayList<>();
    Arrays.sort(nums);
    permute(nums, sol, new ArrayList<>(), 0);
    return sol;
  }
}
