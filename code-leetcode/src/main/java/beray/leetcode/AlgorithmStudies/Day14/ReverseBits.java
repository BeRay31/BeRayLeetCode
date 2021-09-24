package beray.leetcode.AlgorithmStudies.Day14;
// https://leetcode.com/problems/reverse-bits/
public class ReverseBits {
  public int reverseBits(int n) {
    int res = 0;
    for(int i = 0; i < 32; i++) {
      res <<= 1;
      if ((n & 1) == 1) {
        res+=1;
      }
      n = n >>> 1;
    }
    return res;
  }
  public static void main(String[] args) {
    ReverseBits tb = new ReverseBits();
    System.out.println(tb.reverseBits(-3));
  }
}
