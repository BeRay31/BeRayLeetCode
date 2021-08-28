package beray.leetcode.FunChallenges;
public class LongestPalindromicSubstring {
  public String longestPalindromicSubstring(String s) {
    int leftPointer = 0;
    String longestPalindrom = "";
    while (leftPointer != (s.length()-1) ) {
      int localLeftPointer = leftPointer;
      int rightPointer = (s.length()-1);
      String leftSideString = "";
      String rightSideString = "";
      int iteration = 0;
      while(rightPointer != localLeftPointer && rightPointer > localLeftPointer) {
        System.out.println(localLeftPointer + "{ "+ s.charAt(localLeftPointer) +"()"+ s.charAt(rightPointer) +" }" + rightPointer);
        if(s.charAt((localLeftPointer)) == s.charAt(rightPointer)) {
          Character sameChar = s.charAt(localLeftPointer);
          leftSideString+=sameChar;
          rightSideString=sameChar+rightSideString;
          localLeftPointer++;
          rightPointer--;
        } else {
          leftSideString = "";
          rightSideString = "";
          if(localLeftPointer != leftPointer) {
            iteration++;
            localLeftPointer = leftPointer;
            rightPointer=s.length() - 1 - iteration;
          } else {
            rightPointer--;
          }
        }
      }
      if(rightPointer == localLeftPointer) {
        leftSideString+=s.charAt(rightPointer);
      }
      String tempAns = leftSideString + rightSideString;
      if(tempAns.length() >= longestPalindrom.length()) {
        longestPalindrom = tempAns;
      }
      System.out.println(longestPalindrom);
      leftPointer++; 
    }
    if(leftPointer == (s.length()-1)) {
      String tempAns = ""+s.charAt(s.length()-1);
      if(longestPalindrom.length() < tempAns.length()) {
        longestPalindrom = tempAns;
      }
    }
    return longestPalindrom;
  }

  public static String lpsBrute(String s) { // TODO:: TLE 
    int lengthS = s.length();
    if (lengthS == 1) return s;
    int maxLps = 0;
    String currentMaxLps = "";
    for(int i = 0; i < lengthS; i++) {
      for(int j = i; j <= lengthS; j++) { // substring reason
        int currMax = maxLps;
        maxLps = Math.max(maxLps, isPalindrome(s.substring(i, j)));
        if(currMax != maxLps) {
          currentMaxLps = s.substring(i, j);
        }
      }
    }
    return currentMaxLps;
  }

  public static String lpsDp(String s) { //TODO:: AC but 273ms with 2 base case and 2 case (with calculating the unknown area)-- Vertically iterative
    int length = s.length();
    if (length == 1) return s;
    int[] solution = new int[]{0,0};
    int[][] dp = new int[length][length];
    for(int j = 0; j < length; j++) { // make it go iteratively horizontal than vertically cuz there are any chance if d[i+1][j-1] is unknown when we horizontally iterative
      for(int i = 0; i <= j; i++) {
        if(dp[i][j] == 0 ) {
          if(i > j) {
            continue;
          } else if(i == j) {
            dp[i][j] = 1;
          } else if(i + 1 == j && s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2;
          } else {
            if(s.charAt(i) == s.charAt(j)) {
              if (dp[i+1][j-1] > 0) {
                dp[i][j] = 2 + dp[i+1][j-1];
              } else {
                continue;
              }
            } else {
              continue;
            }
          }
          if(dp[i][j] >= dp[solution[0]][solution[1]]) {
            solution[0] = i;
            solution[1] = j;
          }
        }
      }
    }
    return s.substring(solution[0], solution[1] + 1);
  }

  public static int isPalindrome(String s) {
    int length = s.length();
    if(length == 0) return -1;
    int i = 0;
    int j = length - 1;
    while(i <= j && i < length && j >= 0) {
      if(s.charAt(i) == s.charAt(j)) {
        i++;
        j--;
      } else {
        return -1;
      }
    }
    return length;
  }

  public static void main(String[] args) {
    String test = "aba";
    System.out.println(lpsDp(test));
  }
}