// leetcode https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
  public static int solutionBrute(int[] height) { // 2038 ms
    int maxArea = 0;
    for(int i = 0; i < height.length; i++) {
      for(int j = 0; j < height.length; j++) {
        if(i != j) {
          maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * Math.abs(i - j));
        }
      }
    }
    return maxArea;
  }

  public static int solutionPointer(int[] height) { //5 ms
    int l = 0;
    int r = height.length - 1;
    int maxArea = 0;
    while(l < r) {
      maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r-l));
      if(height[l] > height[r]) {
        r--;
      } else {
        l++;
      }
    }
    return maxArea;
  }
}
