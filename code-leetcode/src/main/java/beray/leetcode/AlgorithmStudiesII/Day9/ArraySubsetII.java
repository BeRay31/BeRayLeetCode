package beray.leetcode.AlgorithmStudiesII.Day9;
// https://leetcode.com/problems/subsets-ii/
import java.util.*;
public class ArraySubsetII {
  public void backtrackHelper(int[] nums, List<List<Integer>> sol, List<Integer> temp, int start) {
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) continue;
      temp.add(nums[i]);
      sol.add(new ArrayList(temp));
      backtrackHelper(nums, sol, temp, i + 1);
      temp.remove(temp.size() - 1);
    }
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> sol = new ArrayList<>();
    sol.add(new ArrayList<>());
    Arrays.sort(nums);
    backtrackHelper(nums, sol, new ArrayList<>(), 0);
    return sol;
  }
}
