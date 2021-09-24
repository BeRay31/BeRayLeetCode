package beray.leetcode.AlgorithmStudies.Day13;
// https://leetcode.com/problems/number-of-1-bits/
public class NumberOf1Bits {
  // Basic bit shifting
  public int hammingWeight(int n) {
    int sumOne = 0;
    while (n != 0) {
      sumOne = sumOne + (n & 1);
      n = n >>> 1;
    }
    return sumOne;
  }
}
