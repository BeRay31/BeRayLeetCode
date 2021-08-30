package beray.leetcode.AlgorithmStudies.Day4;
// https://leetcode.com/problems/reverse-string/

public class ReverseString {
  public void twoPointer(char[] s) {
    int left = 0;
    int right = s.length - 1;

    while (left < right) {
      char temp = s[left];
      s[left] = s[right];
      s[right] = temp;
      left++;
      right--;
    }
  }
}
