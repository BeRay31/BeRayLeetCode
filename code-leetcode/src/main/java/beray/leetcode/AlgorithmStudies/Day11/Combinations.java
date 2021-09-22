package beray.leetcode.AlgorithmStudies.Day11;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combinations/
public class Combinations {
  public void combineHelper(int n, int k, int i, List<Integer> selCom, List<List<Integer>> res) {
    if (k == 0) {
      res.add(new ArrayList<Integer>(selCom));
    } else {
      for(;i <= n; i++) {
        selCom.add(i);
        combineHelper(n, k - 1, i + 1, selCom, res);
        selCom.remove(selCom.size() - 1);
      }
    }
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> selCol = new ArrayList<>();
    combineHelper(n, k, 1, selCol, res);
    return res;
  }
}
