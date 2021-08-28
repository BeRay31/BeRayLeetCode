package FunChallenges;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FunWithAnagrams {
  public static List<String> funWithAnagrams(List<String> text) {
    int arLength = text.size();
    if(arLength <=1) return text;
    for(int i = 0; i < arLength; i++) {
      ArrayList<String> toBeRemoved = new ArrayList<>();
      for(int j = i+1; j < arLength; j++) {
        String textI = text.get(i);
        String textJ = text.get(j);
        if(isAnagram(textI, textJ)) {
          toBeRemoved.add(textJ);
        }
      }
      for(String s : toBeRemoved) {
        text.remove(s);
      }
      arLength = text.size();
    }
    Collections.sort(text);
    return text;
  }
  public static boolean isAnagram(String s1, String s2) {
    HashMap<Character, Integer> s1Map = new HashMap<>();
    HashMap<Character, Integer> s2Map = new HashMap<>();
    int m = s1.length();
    int n = s2.length();
    if(m != n) return false;
    for(int i = 0 ; i < m; i++) {
      char currentKey = s1.charAt(i);
      if(s1Map.containsKey(currentKey)) {
        s1Map.put(currentKey, s1Map.get(currentKey)+1);
      } else {
        s1Map.put(currentKey, 1);
      }
    }
    for(int i = 0 ; i < n; i++) {
      char currentKey = s2.charAt(i);
      if(s2Map.containsKey(currentKey)) {
        s2Map.put(currentKey, s2Map.get(currentKey)+1);
      } else {
        s2Map.put(currentKey, 1);
      }
    }
    for(char key: s1Map.keySet()) {
      if(!s2Map.containsKey(key)) {
        return false;
      } else if(s2Map.get(key) != s1Map.get(key)) {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    ArrayList<String> test = new ArrayList<>();
    test.add("code");
    test.add("aaagmnrs");
    test.add("anagrams");
    test.add("doce");
    // test.add("frame");
    System.out.println(funWithAnagrams(test).toString());
  }
}
