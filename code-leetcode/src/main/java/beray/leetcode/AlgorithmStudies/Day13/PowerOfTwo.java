package beray.leetcode.AlgorithmStudies.Day13;
// https://leetcode.com/problems/power-of-two/
public class PowerOfTwo {
  public boolean isPowerOfTwo(int n) {
    while (n != 0) {
      if ((n & 1) != 1) {
        return false;
      }
      n = n >>> 1;
    }
    return true;
  }
}
