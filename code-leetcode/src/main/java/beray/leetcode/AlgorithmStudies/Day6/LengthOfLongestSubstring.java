package beray.leetcode.AlgorithmStudies.Day6;
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LengthOfLongestSubstring {
  public int slidingWindows (String s) {
    if (s.length() < 2) return s.length();
    int[] utfMap = new int[256];
    int i = 0;
    int substringStart = i;
    int maxSubstringLength = 0;
    int tempMax = 0;
    while (i < s.length()) {
      int charAt = Integer.valueOf(s.charAt(i));
      if (i == 0 || utfMap[charAt] < substringStart || (utfMap[charAt] == 0 && s.charAt(utfMap[charAt]) != s.charAt(i))) {
        utfMap[charAt] = i;
      } else {
        substringStart = utfMap[charAt] + 1;
        utfMap[charAt] = i;
        maxSubstringLength = Math.max(tempMax, maxSubstringLength);
        tempMax = i - substringStart;
      }
      tempMax += 1;
      i++;
    }
    maxSubstringLength = Math.max(tempMax, maxSubstringLength);
    return Math.max(tempMax, maxSubstringLength);
  }

  public static void main(String[] args) {
    LengthOfLongestSubstring ls = new LengthOfLongestSubstring();
    System.out.println(ls.slidingWindows("au"));
  }
}
