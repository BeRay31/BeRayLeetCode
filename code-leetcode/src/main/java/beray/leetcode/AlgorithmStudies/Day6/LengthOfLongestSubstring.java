package beray.leetcode.AlgorithmStudies.Day6;

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
      System.out.print(s.charAt(i) + " ");
      if (i == 0 || utfMap[charAt] < substringStart || (utfMap[charAt] == 0 && s.charAt(utfMap[charAt]) != s.charAt(i))) {
        System.out.println("HERE A");
        utfMap[charAt] = i;
      } else {
        System.out.println("HERE B");
        substringStart = utfMap[charAt] + 1;
        utfMap[charAt] = i;
        maxSubstringLength = Math.max(tempMax, maxSubstringLength);
        tempMax = i - substringStart;
      }
      System.out.println(tempMax);
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
