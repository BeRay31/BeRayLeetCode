package beray.leetcode.AlgorithmStudies.Day13;
// https://leetcode.com/problems/power-of-two/
public class PowerOfTwo {
  public boolean isPowerOfTwo(int n) {
    if (n < 0) return false;
    int sumOne = 0;
    while (n != 0) {
      sumOne = sumOne + (n & 1);
      n = n >>> 1;
    }
    if (sumOne == 1) return true;
    else return false;
  }

  public boolean isPowerOfTwoBit(int n) {
    return n >= 0 && (n & (n - 1)) == 0;
  }

  public boolean powerOfTwo(int n) {
    if (n == 0) return false;
    else return n >= Integer.MAX_VALUE || n <= Integer.MIN_VALUE ? ((long)n&(long)-n) == n : (n&-n) == n;
  }
}
