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

  public String ImprovedReserveStrings(String s) {
    char[] charArray = s.toCharArray();
    int firstIndex = 0;
    int lastIndex = 0;

    for (int i = 0; i < charArray.length; i++) {
      if (charArray[i] == ' ') {
        lastIndex = i - 1;
        this.ImprovedReverseWord(charArray, firstIndex, lastIndex);
        firstIndex = i + 1;
      } else if (i == charArray.length - 1) {
        lastIndex = i;
        this.ImprovedReverseWord(charArray, firstIndex, lastIndex);
      }
    }

    return new String(charArray);
  }

  public static void main(String[] args) {
    String s = "Let's take LeetCode contest";
    ReverseWordInString reverser = new ReverseWordInString();
    System.out.println(reverser.ImprovedReserveStrings(s));
  }
}
