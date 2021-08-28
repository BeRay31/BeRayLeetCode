package FunChallenges;
// EASY: Count and Say: https://leetcode.com/problems/count-and-say/

public class CountAndSay {
  public static String solution(int n) {
    if(n == 1) {
      return "1";
    } else {
        String cns = solution(n-1);
        String output = "";
        int count = 1;
        char currChar = cns.charAt(0);
        for(int i = 1; i < cns.length(); i++) {
            if(currChar != cns.charAt(i)) {
                output+= Integer.toString(count) + Character.toString(currChar);
                count = 0;
                currChar = cns.charAt(i);
            }
            count++;
        }
        output += Integer.toString(count) + Character.toString(currChar);
        return output;
    }
  }
}
