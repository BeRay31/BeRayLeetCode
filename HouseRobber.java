public class HouseRobber {
  public static int solution(int[] nums) {
    int rob = 0;
    int noRob = 0;
    for(int n : nums) {
      int tempPrevNo = noRob;
      noRob = Math.max(noRob, rob);
      rob = n + tempPrevNo;
    }
    return Math.max(noRob, rob);
  }
}
