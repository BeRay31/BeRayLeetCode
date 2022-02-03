package beray.leetcode.AlgorithmStudiesII.Day14;
// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
  public String longestPalindrome(String s) {
    int n = s.length();
    if (n <= 1) return s;
    if (n == 2 && s.charAt(0) == s.charAt(1)) return s;
    boolean[][] memo = new boolean[n][n];
    String sol = "";
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        memo[i][j] = s.charAt(i) == s.charAt(j) && (j - i + 1 < 3 || memo[i - 1][j + 1]);
        if (memo[i][j] && sol.length() < j - i + 1) sol = s.substring(i, j + 1);
      }
    }
    return sol;
  }
}
