package beray.leetcode.FunChallenges;
public class JumpingOnTheClouds {
  public static int solution(int[] c) {
    int numJump = 0;
    for(int i = 0; i < c.length; i++) {
      if(i + 2 < c.length) {
        if(c[i+2] == 0) {
          i++;
          numJump++;
        } else if(c[i+1] == 0) {
          numJump++;
        }
      } else if(i + 1 < c.length) {
        numJump++;
      }
    }
    return numJump;
  }
}
