package beray.leetcode.AlgorithmStudiesII.Day10;
// https://leetcode.com/problems/combination-sum/
import java.util.*;
public class CombinationSum {
  public void exploreCombination(int[] candidates, int target, List<Integer> temp, List<List<Integer>> sol, int sum, int start) {
    if (sum > target) return;
    if (sum == target) {
      sol.add(new ArrayList<>(temp));
      return;
    }
    for (int i = start; i < candidates.length; i++) {
      temp.add(candidates[i]);
      sum += candidates[i];
      exploreCombination(candidates, target, temp, sol, sum, i);
      temp.remove(temp.size() - 1);
      sum -= candidates[i];
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> sol = new ArrayList<>();
    exploreCombination(candidates, target, new ArrayList<>(), sol, 0, 0);
    return sol;
  }
}
