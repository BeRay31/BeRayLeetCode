public class LongestCommonPrefix {
  public static String solution(String[] strs) {
    if (strs.length == 0) return "";
    String commonPrefix = strs[0];
    for(int i = 1; i < strs.length; i++) {
      commonPrefix = getCommonPrefix(commonPrefix, strs[i]);
    }
    return commonPrefix;
  }

  public static String getCommonPrefix(String s1, String s2) {
    String minString;
    if(s1.length() > s2.length()) {
      minString = s2;
    } else {
      minString = s1;
    }
    for(int i = 0; i < minString.length(); i++) {
      if(s1.charAt(i) != s2.charAt(i)) {
        return minString.substring(0, i);
      }
    }
    return minString;
  }
}
