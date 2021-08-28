package FunChallenges;
import java.util.HashMap;

public class RomanToInt {
  public static int solution(String s) {
    HashMap<String, Integer> romToInt = new HashMap<>();
    romToInt.put("M", 1000);
    romToInt.put("CM", 900);
    romToInt.put("D", 500);
    romToInt.put("CD", 400);
    romToInt.put("C", 100);
    romToInt.put("XC", 90);
    romToInt.put("L", 50);
    romToInt.put("XL", 40);
    romToInt.put("X", 10);
    romToInt.put("IX", 9);
    romToInt.put("V", 5);
    romToInt.put("IV", 4);
    romToInt.put("I", 1);

    int decimal = 0;
    for(int i = 0; i < s.length(); i++) {
      String currentRoman = ""+s.charAt(i);
      if(s.charAt(i) == 'I') {
        if(i < s.length() - 1) {
          if(s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X') {
            i++;
            currentRoman += s.charAt(i);
            decimal += romToInt.get(currentRoman);
          } else {
            decimal += romToInt.get(currentRoman);
          }
        } else {
          decimal += romToInt.get(currentRoman);
        }
      } else if(s.charAt(i) == 'X') {
        if (i < s.length() - 1) {
          if(s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C') {
            i++;
            currentRoman += s.charAt(i);
            decimal += romToInt.get(currentRoman);
          } else {
            decimal += romToInt.get(currentRoman);
          }
        } else {
          decimal += romToInt.get(currentRoman);
        }
      } else if(s.charAt(i) == 'C') {
        if(i < s.length() -1) {
          if(s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M') {
            i++;
            currentRoman += s.charAt(i);
            decimal += romToInt.get(currentRoman);
          } else {
            decimal += romToInt.get(currentRoman);
          }
        } else {
          decimal += romToInt.get(currentRoman);
        }
      } else {
        decimal += romToInt.get(currentRoman);
      }
    }
    return decimal;
  }
  public static void main(String[] args) {
    System.out.println(solution("III"));
  }
}
