package beray.leetcode.AlgorithmStudies.Day11;
// https://leetcode.com/problems/permutations/

import java.util.ArrayList;
import java.util.List;

public class Permutations {
  public void permutationsHelper(List<Integer> temp, List<List<Integer>> res, int[] list, int k) {
    int listLength = list.length;
    if (k == listLength) {
      res.add(new ArrayList<>(temp));
    } else {
      for (int i = 0; i < listLength; i++) {
        if (!temp.contains(list[i])) {
          temp.add(list[i]);
          permutationsHelper(temp, res, list, k + 1);
          temp.remove(temp.size() - 1);
        }
      }
    }
  }

  public List<List<Integer>> permutate(int[] list) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    permutationsHelper(temp, res, list, 0);
    return res;
  }
  
}
