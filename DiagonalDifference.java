import java.util.*;
public class DiagonalDifference {
  public static int diagonalDifference(List<List<Integer>> arr) {
    // Write your code here
    int res = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    int v = arr.size()-1;
    while(i != arr.size() && v != -1) {
      System.out.println(arr.get(i).get(j));
      System.out.println(arr.get(k).get(v));
      res += arr.get(i).get(j);
      res -= arr.get(k).get(v);
      // diagonal \
      i++;
      j++;
      // diagonal /
      v--;
      k++;
    }
    return Math.abs(res);
  }
}
