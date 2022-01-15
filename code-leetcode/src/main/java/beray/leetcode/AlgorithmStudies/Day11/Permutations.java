package beray.leetcode.AlgorithmStudies.Day11;
// https://leetcode.com/problems/permutations/

import java.util.ArrayList;
import java.util.List;

public class Permutations {
  public void helper(List<List<Integer>> sol, int[] list, int bitMask, List<Integer> temp) {
    if (bitMask == 63) {
      sol.add(new ArrayList<>(temp));
    } else {
      for (int i = 0; i < list.length; i++) {
        if (((bitMask >> i) ^ 1) == 1) {
          temp.add(list[i]);
          bitMask |= (1 << i);
          helper(sol, list, bitMask, temp);
          temp.remove(temp.size() - 1);
          bitMask ^= (1 << i);
        }
      }
    }
  }

  public List<List<Integer>> permutate(int[] list) {
    List<List<Integer>> sol = new ArrayList<>();
    helper(sol, list, 0, new ArrayList<>());
    return sol;
  }
}
