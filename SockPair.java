import java.util.HashMap;

public class SockPair {
  public static int solution(int n, int[] ar) {
    HashMap<Integer, Integer> sockMap = new HashMap<>();
    int pairs = 0;
    for(int i = 0 ; i < n; i++) {
      if(!sockMap.containsKey(ar[i])) {
        sockMap.put(ar[i], 1);
      } else {
        sockMap.put(ar[i], sockMap.get(ar[i])+1);
      }
    }
    for(int key : sockMap.keySet()) {
      pairs += (sockMap.get(key)/2);
    }
    return pairs;
  }
  public static void main(String[] args) {
    int[] test = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
    System.out.println(solution(9, test));
  }
}
