package beray.leetcode.AlgorithmStudies.Day13;
// https://leetcode.com/problems/number-of-1-bits/
public class NumberOf1Bits {
  // Basic bit shifting
  public int hammingWeight(int n) {
    int sum = 0;
    while (n != 0) {
      if ((n & 1) == 1) sum++;
      n = n >>> 1;
    }
    return sum;
  }
}
