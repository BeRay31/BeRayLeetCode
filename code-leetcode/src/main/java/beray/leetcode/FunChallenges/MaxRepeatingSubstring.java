package beray.leetcode.FunChallenges;

public class MaxRepeatingSubstring {
  public static int solution(String sequence, String word) {
    int m = sequence.length();
    int n = word.length();
    int repeat = 0;
    int maxRepeat = 0;
    if(m < n) return repeat;
    int j = 0;
    for(int i = 0; i < m; i++) {
      System.out.println(i+" "+j);
      if(sequence.charAt(i) == word.charAt(j)) {
        j++;
      } else {
        i = i - j;
        if(repeat > 0) {
          i -= n*(repeat-1);
        }
        j = 0;
        maxRepeat = Math.max(maxRepeat, repeat);
        repeat = 0;
      }
      if(j == n) {
        repeat++;
        j = 0;
      }
    }
    if(j == n) {
      repeat++;
      j = 0;
    }
    maxRepeat = Math.max(maxRepeat, repeat);
    return maxRepeat;
  }
  public static void main(String[] args) {
    System.out.println(solution("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
  }
}
// "aaabaaaabaaabaaaabaaaabaaaabaaaaba"
// "aaaba"
