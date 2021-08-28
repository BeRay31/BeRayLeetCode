package FunChallenges;
// Zigzag string https://leetcode.com/problems/zigzag-conversion/submissions/
public class ZigZagConversion {
  public static String solution(String s, int numRows) {
    if(numRows == 1) return s;
    int numCol = s.length()/2;
    if(s.length() % 2 != 0) numCol++;
    char[][] zigzag = new char[numRows][numCol];
    int currentCharIndex = 0;
    int i = 0;
    int j = 0;
    boolean isUp = false;
    while(currentCharIndex < s.length()) {
      zigzag[i][j] = s.charAt(currentCharIndex);
      currentCharIndex++;
      if(isUp) { //go diagonally up
        i--;
        j++;
        if(i == 0) {
          isUp = false;
        }
      } else { // go down
        i++;
        if(i == numRows - 1) {
          isUp = true;
        }
      }
    } return printStr(zigzag);
  }
  
  public static void print(char[][] zigzag) {
    for(int i = 0; i < zigzag.length; i++) {
      for(int j = 0; j < zigzag[i].length; j++) {
        System.out.print(zigzag[i][j]);
      }
      System.out.println();
    }
  }

  public static String printStr(char[][] cc) {
    String s = "";
    for(int i = 0; i < cc.length; i++) {
      for(int j = 0; j < cc[i].length; j++) {
        if(cc[i][j] != 0) {
          s += Character.toString(cc[i][j]);
        }
      }
    }
    return s;
  }

  public static void main(String[] args) {
    solution("PAYPALISHIRING", 3);
  }
}

// PAYPALISHIRING
// P    A   H   N
// A  P L S I I G
// Y    I   R

// PAYPALISHIRING
// P      I     N
// A    L S   I G
// Y  A   H R
// P      I

// PAYPALISHIRING
// P  Y A I H R N
// A  P L S I I G