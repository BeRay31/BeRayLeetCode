package beray.leetcode.AlgorithmStudies.Day6;
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LengthOfLongestSubstring {
  public int slidingWindows (String s) {
    char[] chars = s.toCharArray();
    int n = chars.length;
    if (n < 2) return n;
    int[] loc = new int[128];
    int lp = 0;
    int max = 0;
    for (int i = 0; i < n; i++) {
      int curLoc = loc[chars[i]];
      if (curLoc >= lp && i != 0 && chars[i] == chars[curLoc]) {
        max = Math.max(max, i - curLoc);
        lp = curLoc + 1;
        loc[chars[i]] = i;
      } else {
        loc[chars[i]] = i;
      }
    }
    max = Math.max(max, n - lp);
    return max;
  }

  public static void main(String[] args) {
    LengthOfLongestSubstring ls = new LengthOfLongestSubstring();
    System.out.println(ls.slidingWindows("au"));
  }
}
