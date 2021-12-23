package beray.leetcode.Shopee;
import java.util.*;

public class ShopeeInterview {
  public static void flashSale() {
    int[][] input = { {3, 5}, {9, 16}, {18, 21}, {3, 6}, {9, 12} };
    Arrays.sort(input, (int[] a, int[] b) -> { return (a[0] - b[0]); });
    int last = Integer.MIN_VALUE;
    int total = 0;
    for (int i = 0; i < input.length; i++) {
      int[] curr = input[i];
      total += Math.max(0, curr[1] - Math.max(last, curr[0]));
      last = Math.max(last, curr[1]);
    }
    System.out.println("Total Hours: " + total);
  }

  public static boolean dfs(HashMap<String, ArrayList<String>> map, String target, String currValue, HashMap<String, Boolean> visited) {
    if (!map.containsKey(currValue)) return false;
    if (visited.containsKey(currValue)) return false;
    ArrayList<String> ll = map.get(currValue);
    visited.put(currValue, true);
    boolean isAchievable = false;
    for (String s: ll) {
      isAchievable = isAchievable || target == s || dfs(map, target, s, visited);
    }
    return isAchievable;
  }

  public static void infer(String[] args) {
    String[][] input = {{"bag", "purse"}, {"purse", "bag"}, {"purse", "hand purse"}, {"bag", "backpack"}, {"purse", "purse wallet"}, {"purse wallet", "coin wallet"}, {"purse wallet", "man purse"}, {"shoe", "nike shoe"}};
    HashMap<String, ArrayList<String>> map = new HashMap();
    // Built the map
    for (String[] pair: input) {
      if (map.containsKey(pair[0])) {
        map.get(pair[0]).add(pair[1]);
      } else {
        ArrayList<String> ll = new ArrayList();
        ll.add(pair[1]);
        map.put(pair[0], ll);
      }
    }
    String start = "bag";
    String end = "coin wallet";
    HashMap<String, Boolean> visited = new HashMap();
    if (dfs(map, end, start, visited)) System.out.println("Is achieveable");
    else System.out.println("Not Achieveable");
  }

}


