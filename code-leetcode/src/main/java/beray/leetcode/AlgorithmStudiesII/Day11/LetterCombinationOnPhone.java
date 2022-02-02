package beray.leetcode.AlgorithmStudiesII.Day11;
import java.util.*;
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationOnPhone {
  public char[][] phone = new char[][]{{},{},{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t','u', 'v'}, {'w', 'x', 'y', 'z'}};
  
  public void exploreCombination(char[] digitsArr, int currDigits, char[] temp, List<String> sol) {
    int currentPad = digitsArr[currDigits] - 48;
    for (int i = 0; i < phone[currentPad].length; i++) {
      temp[currDigits] = phone[currentPad][i];
      if (currDigits + 1 == digitsArr.length) sol.add(new String(temp));
      else exploreCombination(digitsArr, currDigits + 1, temp, sol);
    }
  }
  
  public List<String> letterCombinations(String digits) {
    List<String> sol = new ArrayList<>();
    char[] digitsArr = digits.toCharArray();
    if (digitsArr.length > 0) exploreCombination(digitsArr, 0, new char[digitsArr.length], sol);
    return sol;      
  }
}
