package beray.leetcode.AlgorithmStudies.Day11;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-case-permutation/
public class LetterCasePermutation {
  public char invertChar(char input) {
    if (input < 97 ) return (char)((int)input + 32);
    else return (char)((int)input - 32);
  }

  public void helper(char[] charArr, int index, char[] temp, List<String> sol) {
    if (index == charArr.length) sol.add(new String(temp));
    else {
      if (charArr[index] >= 65 && charArr[index] <= 122) {
        temp[index] = invertChar(charArr[index]);
        helper(charArr, index + 1, temp, sol);
      }
      temp[index] = charArr[index];
      helper(charArr, index + 1, temp, sol);
    }
  }
  
  public List<String> letterCasePermutation(String s) {
    int sz = s.length();
    List<String> sol = new ArrayList<>();
    char[] temp = new char[sz];

    char[] charArr = s.toCharArray();
    helper(charArr, 0, temp, sol);
    return sol;
  }
}
