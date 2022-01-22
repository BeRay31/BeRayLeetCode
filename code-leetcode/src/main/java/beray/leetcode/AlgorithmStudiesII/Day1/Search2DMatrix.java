package beray.leetcode.AlgorithmStudiesII.Day1;
// https://leetcode.com/problems/search-a-2d-matrix/
public class Search2DMatrix {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int up = 0;
    int down = m - 1;
    if (m > 1) { // remember here if seeking upper value use up, viceversa, for example 1 2 5 and target is 4, then the bottom value is 2 and the upper value is 5 
      while (up <= down) {
        int mid = up + (down - up)/2;
        if (matrix[mid][0] < target) up = mid + 1;
        else if (matrix[mid][0] > target) down = mid - 1;
        else return true;
      }
    }
    if (down < 0) return false;
    int left = 0;
    int right = n - 1;
    while (left <= right) {
      int mid = left + (right - left)/2;
      if (matrix[down][mid] > target) right = mid - 1;
      else if (matrix[down][mid] < target) left = mid + 1;
      else return true;
    }
    return false;
  }
}