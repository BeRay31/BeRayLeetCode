package beray.leetcode.AlgorithmStudiesII.Day11;
// https://leetcode.com/problems/generate-parentheses/
import java.util.*;
public class GenerateParentheses {
  public void exploreParentheses(int n, int openCount, int closeLeft, String temp, List<String> sol) {
    if (openCount == n && closeLeft == 0) sol.add(temp);
    if (openCount < n) exploreParentheses(n, openCount + 1, closeLeft + 1, temp + "(", sol);
    if (closeLeft > 0) exploreParentheses(n, openCount, closeLeft - 1, temp + ")", sol);
  }
  public List<String> generateParenthesis(int n) {
    List<String> sol = new ArrayList<>();
    exploreParentheses(n, 0, 0, "", sol);
    return sol;
  }
}
