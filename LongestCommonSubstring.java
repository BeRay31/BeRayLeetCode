public class LongestCommonSubstring {
  public static int lcsRecursion(String s1, String s2, int length1, int length2, int maxLcs) {
    if(length1 == 0 || length2 == 0) return maxLcs;
    if(s1.charAt(length1-1) == s2.charAt(length2-1)) {
      maxLcs = lcsRecursion(s1, s2, length1-1 , length2-1, 1 + maxLcs);
    }
    int count1 = lcsRecursion(s1, s2, length1-1, length2, 0);
    int count2 = lcsRecursion(s1, s2, length1, length2-1, 0);
    return Math.max(maxLcs, Math.max(count1, count2));
  }

  public static int lcsDp(String s1, String s2) { // DP with 1 case
    int length1 = s1.length();
    int length2 = s2.length();

    int maxLcs = 0;

    if(length1 == 0 || length2 == 0) return 0;

    int[][] dp = new int[length1+1][length2+1];
    // Sample bedc berc
    for(int i = 0; i < length1; i++) {
      for(int j = 0; j < length2; j++) {
        if(i == 0 || j == 0) { // basis
          dp[i][j] = 0;
        }else if(s1.charAt(i-1) == s2.charAt(j-1)) {
          dp[i][j] = 1 + dp[i-1][j-1];
          maxLcs = Math.max(maxLcs, dp[i][j]);
        } else {
          dp[i][j] = 0;
        }
      }
    }
    return maxLcs;
  }

  public static void main(String[] args) {
    String s1 = "bedc";
    String s2 = "berc";

    System.out.println(lcsRecursion(s1, s2, s1.length(), s2.length(),0));
  }
}
