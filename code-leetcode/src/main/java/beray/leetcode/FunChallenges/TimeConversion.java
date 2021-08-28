package beray.leetcode.FunChallenges;
public class TimeConversion {
  public String solution(String s) {
    String exp = s.substring(7);
    String fisrtDigit = s.substring(0, 2);
    String elses = s.substring(2, 8);
    if(exp.equals("AM")) {
      return fisrtDigit + elses;
    } else {
      int now = Integer.parseInt(fisrtDigit);
      return (now+12) + elses;
    }
  }
}
