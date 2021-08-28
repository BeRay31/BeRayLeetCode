// Use sliding window algorithm with ascii map
public class LongestNonRepeatingSubstring {
  public static int solution(String s) {
    int n = s.length();
    if(n == 0) return 0;
    int longest = 0;
    int left = 0;
    int right = 0;

    int[] map = new int[255];
    while(left < n && right < n) {
      if(map[s.charAt(right)] == 1) {
        longest = Math.max(longest, right - left);
        map[s.charAt(left)] = 0;
        left++;
      } else {
        map[s.charAt(right)] = 1;
        right++;
      }
    }
    int length = right - left;
    if(left == right) {
      length = Math.max(length, 1);
    }
    longest = Math.max(longest, length);
    return longest;
  }
  public static void main(String[] args) {
    String test = "TESTALSDNA:LSD";
    System.out.println(LongestNonRepeatingSubstring.solution(test));
  }
}
