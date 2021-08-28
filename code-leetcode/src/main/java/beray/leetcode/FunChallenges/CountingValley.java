package beray.leetcode.FunChallenges;
public class CountingValley {
  public static int solution(int steps, String path) {
    int seaLevel = 0;
    int numValley = 0;
    boolean isValley = false;
    for(int i = 0; i < steps; i++) {
      if(path.charAt(i) == 'U') {
        seaLevel++;
      } else if(path.charAt(i) == 'D'){
        seaLevel--;
      }
      if(seaLevel < 0) {
        isValley = true;
      }
      if(seaLevel == 0 && isValley) {
        isValley = false;
        numValley++;
      }
    }
    return numValley;
  }
  public static void main(String[] args) {
    System.out.println(solution(12, "DDUUDDUDUUUD"));
  }
}
