public class PalindromeNumber {
  public static boolean solution(int x) {
    if (x < 0) return false;
    int reversedNumber = 0;
    int currNumber = x;
    while (currNumber > 0) {
      int lastDigit = currNumber % 10;
      reversedNumber = reversedNumber*10 + lastDigit;
      currNumber = currNumber/10;
    }

    if (reversedNumber == x) return true; 
    else return false;
  }
}
