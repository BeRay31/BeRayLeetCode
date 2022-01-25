package beray.leetcode.AlgorithmStudiesII.Day4;
// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
  public int maxArea(int[] height) {
    if (height.length == 2) return Math.min(height[0], height[1]);
    int left = 0;
    int right = height.length - 1;
    int max = 0;
    while (left < height.length && right > 0 && left < right) {
      int area = Math.min(height[left], height[right]) * (right - left);
      max = Math.max(area, max);
      if (height[left] > height[right]) right--;
      else left++;
    }
    return max;
  }
}
