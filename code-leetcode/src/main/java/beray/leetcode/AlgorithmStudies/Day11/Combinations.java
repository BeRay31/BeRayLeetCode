package beray.leetcode.AlgorithmStudies.Day11;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/
public class Combinations {
  public void combineHelper(List<List<Integer>> sol, int n, int k, int sum, List<Integer> temp) {
    if (sum == k) {
      sol.add(new ArrayList<>(temp));
    } else {
      int sz = temp.size();
      int start = sz > 0 ? temp.get(sz - 1) : 0;

      for (int i = start + 1; i <= n; i++) {
        temp.add(i);
        combineHelper(sol, n, k, sum + 1, temp);
        temp.remove(sz);
      }
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> sol = new ArrayList<>();
    combineHelper(sol, n, k, 0, new ArrayList<>());
    return sol;
  }
}
