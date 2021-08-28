package beray.leetcode.FunChallenges;
public class MiniMaxSum {
  public void solution(int[] arr) {
    long sumAll = 0;
    long min = arr[0];
    long max = arr[0];
    for(int i = 0; i < arr.length; i++) {
      sumAll += arr[i];
      if(arr[i] > max) {
        max = arr[i];
      }
      if(arr[i] < min) {
        min = arr[i];
      }
    }
    System.out.println((sumAll-max) + " " + (sumAll-min));
  }
}
