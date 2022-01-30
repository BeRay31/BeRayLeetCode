package beray.leetcode.AlgorithmStudiesII.Day10;
// https://leetcode.com/problems/combination-sum-ii/
import java.util.*;
public class CombinationSumII {
  public void exploreCombination(int[] candidates, int target, int sum, List<List<Integer>> sol, List<Integer> temp, int start) {
    if (sum > target) return;
    else if (sum == target) {
      sol.add(new ArrayList<>(temp));
      return;
    }
    int lastUsed = Integer.MAX_VALUE;
    for (int i = start; i < candidates.length; i++) {
      if (lastUsed == candidates[i]) continue;
      temp.add(candidates[i]);
      sum += candidates[i];
      lastUsed = candidates[i];
      exploreCombination(candidates, target, sum, sol, temp, i + 1);
      temp.remove(temp.size() - 1);
      sum -= candidates[i];
    }
  }
  
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> sol = new ArrayList<>();
    Arrays.sort(candidates);
    exploreCombination(candidates, target, 0, sol, new ArrayList<>(), 0);
    return sol;    
  }
}
