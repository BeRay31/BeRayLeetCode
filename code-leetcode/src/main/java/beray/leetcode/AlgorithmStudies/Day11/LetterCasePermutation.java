package beray.leetcode.AlgorithmStudies.Day11;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/letter-case-permutation/
public class LetterCasePermutation {
  public int[] val = new int[]{1, -1};

  public char resChar(char x, int opr) {
    if (opr == -1) {
      if (x - 'a' >= 0) {
        return (char) (x - 'a' + 'A');        
      } else {
        return (char) (x - 'A' + 'a');
      }
    } return (char)x;
  }

  public void permuteHelper(List<Integer> temp, int count, String s, List<String> res) {
    if (count == 0) {
      int charIdx = 0;
      String newRes = "";
      for (int i = 0; i < s.length(); i++) {
        int relativeChar = s.charAt(i) - '0';
        if (relativeChar > 9) {
          newRes += resChar(s.charAt(i), temp.get(charIdx));
          charIdx++;
        } else {
          newRes += s.charAt(i);
        }
      }
      res.add(newRes);
    } else {
      for (int i = 0; i < val.length; i++) {
        temp.add(val[i]);
        permuteHelper(temp, count - 1, s, res);
        temp.remove(temp.size() - 1);
      }
    }
  }

  public List<String> letterCasePermute(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      int relativeChar = s.charAt(i) - '0';
      if (relativeChar > 9) {
        count++;
      }
    }
    if (count == 0) {
      List<String> res = new ArrayList<>();
      res.add(s);
    }

    List<String> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    permuteHelper(temp, count, s, res);
    return res;
  }

  public void permuteHelperII(String temp, int count, String s, List<String> res, int strLen) {
    if (count == strLen) {
      res.add(temp);
    } else {
      int relativeChar = s.charAt(count) - '0';
      if (relativeChar > 9) {
        for (int i = 0; i < val.length; i++) {
          String newTemp = temp + resChar(s.charAt(count), val[i]); 
          permuteHelperII(newTemp, count + 1, s, res, strLen);
        }
      } else {
        permuteHelperII(temp + s.charAt(count), count + 1, s, res, strLen);
      }
    }
  }

  public List<String> letterCasePermuteII(String s) {
    List<String> res = new ArrayList<>();
    permuteHelperII("", 0, s, res, s.length());
    return res;
  }

}
