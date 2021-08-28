package beray.leetcode.AlgorithmStudies.Day1;
// https://leetcode.com/problems/first-bad-version/
// Solution Used => Binary Search
public class FirstBadVersion {
  static int badVal;

  public FirstBadVersion(int badVal) {
    FirstBadVersion.badVal = badVal;
  }

  public boolean isBadVersion(int val) {
    return val >= FirstBadVersion.badVal;
  }

  public int firstBad(int n) {
    int left = 1;
    int right = n;
    while (left < right) {
      int mid = left + (right - left)/2;
      if (this.isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }
}
