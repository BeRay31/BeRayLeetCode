package FunChallenges;
import java.util.HashMap;

public class RansomNote {
  public static void solution(String[] magazine, String[] note) {
    HashMap<Character, Integer> magazineMap = new HashMap<>();
    HashMap<Character, Integer> noteMap = new HashMap<>();
    for(int i = 0; i < magazine.length; i++) {
      for(char c : magazine[i].toCharArray()) {
        if(magazineMap.containsKey(c)) {
          magazineMap.put(c, magazineMap.get(c)+1);
        } else {
          magazineMap.put(c, 1);
        }
      }
    }
    for(int i = 0; i < note.length; i++) {
      for(char c : note[i].toCharArray()) {
        if(noteMap.containsKey(c)) {
          noteMap.put(c, noteMap.get(c)+1);
        } else {
          noteMap.put(c, 1);
        }
      }
    }
    for(char c : noteMap.keySet()) {
      if(magazineMap.containsKey(c)) {
        if(magazineMap.get(c) < noteMap.get(c)) {
          System.out.println("No");
          return;
        }
      } else {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
    return;
  } 
}
