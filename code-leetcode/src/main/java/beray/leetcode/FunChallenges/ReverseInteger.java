package beray.leetcode.FunChallenges;
public class ReverseInteger {
  public static int solution(int x) {
    int currNum = x;
    int ans = 0;
    while(currNum != 0) {
      if(ans > Integer.MAX_VALUE/10) return 0;
      if(ans < Integer.MIN_VALUE/10) return 0;
      ans = ans*10 + currNum%10;
      currNum/=10;
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(solution(1534236469));
  }
}
