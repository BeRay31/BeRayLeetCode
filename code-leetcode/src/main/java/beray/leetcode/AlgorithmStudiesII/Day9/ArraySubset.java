package beray.leetcode.AlgorithmStudiesII.Day9;
// https://leetcode.com/problems/subsets/
import java.util.*;
public class ArraySubset {
  public void backtrackHelper(int[] nums, List<List<Integer>> sol, List<Integer> temp, int start) {
    for (int i = start; i < nums.length; i++) {
      temp.add(nums[i]);
      List<Integer> newTemp = new ArrayList<>();
      newTemp.addAll(temp);
      sol.add(newTemp);
      backtrackHelper(nums, sol, temp, i + 1);
      temp.remove(temp.size() - 1);
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> sol = new ArrayList<>();
    sol.add(new ArrayList<>());
    backtrackHelper(nums, sol, new ArrayList<>(), 0);
    return sol;
  }
}
