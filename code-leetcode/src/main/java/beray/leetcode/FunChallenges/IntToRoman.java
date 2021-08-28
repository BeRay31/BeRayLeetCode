package beray.leetcode.FunChallenges;
// int to roman 15ms 40mb https://leetcode.com/problems/integer-to-roman/submissions/

public class IntToRoman {
  public static class StringRep {
    public String rep1;
    public String rep5;
    public String rep10;

    StringRep(String i, String v, String x) {
      this.rep1 = i;
      this.rep5 = v;
      this.rep10 = x;
    }
  }
  public static String solution(int num) {
    StringRep ord1 = new StringRep("I", "V", "X");
    StringRep ord10 = new StringRep("X", "L", "C");
    StringRep ord100 = new StringRep("C", "D", "M");
    StringRep ord1000 = new StringRep("M", "-", "-");
    int ord = 1;
    int currNumber = num;
    String roman = "";
    while(currNumber > 0) {
      int lastDigit = currNumber % 10;
      String currLastDigitRep = "";
      StringRep currRep = ord1;
      switch (ord) {
        case 1:
          currRep = ord1;
          break;
        case 10:
          currRep = ord10;
          break;
        case 100:
          currRep = ord100;
          break;
        case 1000:
          currRep = ord1000;
          break;
        default:
          break;
      }
      while(lastDigit > 0) {
        if(lastDigit == 9) {
          currLastDigitRep += (currRep.rep1+currRep.rep10);
          lastDigit -= 9;
        } else if(lastDigit - 5 >= 0) {
          currLastDigitRep += (currRep.rep5);
          lastDigit -= 5;
        } else if(lastDigit == 4) {
          currLastDigitRep += (currRep.rep1+currRep.rep5);
          lastDigit-=4;
        } else {
          currLastDigitRep += (currRep.rep1);
          lastDigit--;
        }
      }
      roman = currLastDigitRep + roman;
      currNumber = currNumber/10;
      ord*=10;
    }
    return roman;
  }
  public static void main(String[] args) {
    System.out.println(solution(58));
  }
}
