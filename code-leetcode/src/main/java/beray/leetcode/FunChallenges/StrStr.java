package beray.leetcode.FunChallenges;
public class StrStr {
  public static int solution(String haystack, String needle) {
    int m = haystack.length();
    int n = needle.length();
    if(n == 0) return 0;
    int sol = -1;
    int j = 0;
    for(int i = 0; i < m; i++) {
      if(haystack.charAt(i) == needle.charAt(j)) {
        j++;
      } else {
        i = i - j;
        j = 0;
      }
      if(j == n) {
        return i - j;
      }
    }
    return sol;
  }
}
