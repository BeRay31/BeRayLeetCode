package FunChallenges;
import java.util.*;
class ValidParentheses {
  public boolean isValid(String s) {
      ArrayList<Character> charStack = new ArrayList<>();
      for(int i = 0; i < s.length(); i++) {
          if(charStack.size() > 0) {
              System.out.println(s.charAt(i));
              if (s.charAt(i) == '}' && charStack.get(charStack.size()-1) == '{') {
                  charStack.remove(charStack.size()-1);
              } else if (s.charAt(i) == ']' && charStack.get(charStack.size()-1) == '[') {
                  charStack.remove(charStack.size()-1);
              } else if (s.charAt(i) == ')' && charStack.get(charStack.size()-1) == '(') {
                  charStack.remove(charStack.size()-1);
              } else {
                  charStack.add(s.charAt(i));       
              }
          } else {
              charStack.add(s.charAt(i));
          }
      }
      return charStack.size() == 0;
  }
}