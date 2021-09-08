package beray.leetcode.AlgorithmStudies.Day6;
// https://leetcode.com/problems/permutation-in-string/
import java.util.Arrays;

public class PermutationInString {
  public boolean checkInclusion(String s1, String s2) {
    int lenS1 = s1.length();
    int lenS2 = s2.length();
    int[] permutateMap = new int[26];
    int[] checkMap = new int[26];
    int i = 0;

    if (lenS1 > lenS2) return false;
    for (;i < lenS1; i++) {
      permutateMap[(int)s1.charAt(i) - 'a']++;
      checkMap[(int)s2.charAt(i) - 'a']++;
    }
    if (Arrays.equals(permutateMap, checkMap)) return true;

    for (;i< lenS2; i++) {
      if (Arrays.equals(permutateMap, checkMap)) return true;
      checkMap[(int)s2.charAt(i) - 'a']++;
      checkMap[(int)s2.charAt(i-lenS1) - 'a']--;
    }
    if (Arrays.equals(permutateMap, checkMap)) return true;
    return false;
  }

  public static void main(String[] args) {
    PermutationInString pn = new PermutationInString();
    System.out.println(pn.checkInclusion("ab", "eidbaoo"));
  }
}
