package FunChallenges;
public class StaircasePrint {
  public void solution(int n) {
    for(int i = n - 1 ; i >= 0; i--) {
      for(int j = 0; j < n; j++) {
        if(j >= i) {
          System.out.print('#');
        } else {
          System.out.print(' ');
        }
      }
      System.out.println();
    }
  }
}
