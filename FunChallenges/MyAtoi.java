package FunChallenges;
// leetcode atoi https://leetcode.com/problems/string-to-integer-atoi/submissions/
public class MyAtoi {
  public static int solution(String s) {
    int num = 0;
    int isNeg = 1;
    boolean readNum = false;
    for(int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == '-' || s.charAt(i) == '+') {
        if(!readNum) {
          if(s.charAt(i) == '-') {
            isNeg = -1;
          }
          readNum = true;
        } else {
          return num * isNeg;
        }
      } else if(s.charAt(i)-48 >= 0 && s.charAt(i)-48 <= 9) {
        if(!readNum) {
          readNum = true;
        }
        if(Long.valueOf(num)*Long.valueOf(10) + Long.valueOf(s.charAt(i)-48) > Long.valueOf(Integer.MAX_VALUE)) {
          if(isNeg == 1) {
            return Integer.MAX_VALUE;
          } else {
            return Integer.MIN_VALUE;
          }
        }
        num = num*10 + (s.charAt(i) - 48);
      } else {
        if(s.charAt(i) == 32 && !readNum) {
          continue;
        } else {
          return num * isNeg;
        }
      }
    }
    return num * isNeg;
  }

  public static void main(String[] args) {
    System.out.println(solution("  -42"));
  }
}
