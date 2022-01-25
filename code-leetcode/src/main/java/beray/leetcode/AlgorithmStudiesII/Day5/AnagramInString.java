package beray.leetcode.AlgorithmStudiesII.Day5;
// https://leetcode.com/problems/find-all-anagrams-in-a-string/
import java.util.*;
public class AnagramInString {
  public List<Integer> findAnagrams(String s, String p) {
    int ns = s.length();
    int np = p.length();
    List<Integer> sol = new ArrayList<>();
    if (np > ns) return sol;
    char[] cs = s.toCharArray();
    char[] cp = p.toCharArray();
    int[] comp1 = new int[26];
    int[] comp2 = new int[26];
    for (int i = 0; i < np; i++) {
      comp2[cp[i] - 97] += 1;
      comp1[cs[i] - 97] += 1;
    }
    if (Arrays.equals(comp1, comp2)) sol.add(0);
    for (int i = np; i < ns; i++) {
      comp1[cs[i - np] - 97] -= 1;
      comp1[cs[i] - 97] += 1;
      if (Arrays.equals(comp1, comp2)) sol.add(i - np + 1);
    }
    return sol;
  }
}
