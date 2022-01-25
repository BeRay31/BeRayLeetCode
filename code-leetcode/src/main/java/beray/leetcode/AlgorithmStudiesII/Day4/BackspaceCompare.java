package beray.leetcode.AlgorithmStudiesII.Day4;
// https://leetcode.com/problems/backspace-string-compare/
import java.util.*;
public class BackspaceCompare {
  public boolean backspaceCompare(String s, String t) {
    Stack<Character> s1 = new Stack();
    Stack<Character> s2 = new Stack();
    for (char c: s.toCharArray()) {
      if (c == '#') {
        if (s1.size() > 0) s1.pop();
      } else s1.add(c);
    }
    for (char c: t.toCharArray()) {
      if (c == '#') {
        if (s2.size() > 0) s2.pop();
      } else s2.add(c);
    }
    return Arrays.equals(s1.toArray(), s2.toArray());
  }
}
