package beray.leetcode.AlgorithmStudies.Day4;
// https://leetcode.com/problems/reverse-words-in-a-string-iii/

public class ReverseWordInString {
  public String reverseWord(String s) {
    String res = "";
    for (int i = s.length() - 1; i >= 0 ; i--) {
      res += s.charAt(i); 
    }
    return res;
  }

  public String reverseString(String s) {
    String res = "";
    String[] subStrArr = s.split(" ");
    for (int i = 0; i < subStrArr.length; i++) {
      res += this.reverseWord(subStrArr[i]);
      if (i != subStrArr.length - 1) res += " ";
    }
    return res;
  }

  public void ImprovedReverseWord(char[] ca, int left, int right) {
    while (left < right) {
      char temp = ca[left];
      ca[left] = ca[right];
      ca[right] = temp;
      left++;
      right--;
    }
  }

  public void reverse(char[] charArr, int start, int end) {
    while (start < end) {
      char temp = charArr[start];
      charArr[start] = charArr[end];
      charArr[end] = temp;
      start++;
      end--;
    }
  }

  public String ImprovedReserveStrings(String s) {
    char[] charArr = s.toCharArray();
    int n = charArr.length;
    int start = 0;
    for (int i = 0; i < n; i++) {
      if (charArr[i] == ' ') {
        reverse(charArr, start, i - 1);
        start = i + 1;
      }
    }
    if (start < n) {
      reverse(charArr, start, n-1);
    }
    return new String(charArr);
  }

  public static void main(String[] args) {
    String s = "Let's take LeetCode contest";
    ReverseWordInString reverser = new ReverseWordInString();
    System.out.println(reverser.ImprovedReserveStrings(s));
  }
}
