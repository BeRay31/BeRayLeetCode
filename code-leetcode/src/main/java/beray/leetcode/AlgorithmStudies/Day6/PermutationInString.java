package beray.leetcode.AlgorithmStudies.Day6;
// https://leetcode.com/problems/permutation-in-string/
import java.util.Arrays;

public class PermutationInString {
  public boolean checkInclusion(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    if (n > m) return false;
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    int[] comp1 = new int[26];
    int[] comp2 = new int[26];

    for (int i = 0; i < n; i++) {
      comp1[c1[i] - 97]++;
      comp2[c2[i] - 97]++;
    }
    if (Arrays.equals(comp1, comp2)) return true;

    for (int i = n; i < m; i++) {
      comp2[c2[i] - 97]++;
      comp2[c2[i - n] - 97]--;
      if (Arrays.equals(comp1, comp2)) return true;
    }
    return Arrays.equals(comp1, comp2);
  }

  public static void main(String[] args) {
    PermutationInString pn = new PermutationInString();
    System.out.println(pn.checkInclusion("ab", "eidbaoo"));
  }
}
