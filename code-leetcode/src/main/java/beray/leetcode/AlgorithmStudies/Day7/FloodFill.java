package beray.leetcode.AlgorithmStudies.Day7;
// https://leetcode.com/problems/flood-fill/
public class FloodFill {
  public static int[] dir = new int[]{0, 1, 0, -1, 0};
  public void recursiveHelper(int[][] image, int newCol, int sr, int sc, int targetCol) {
    int n = image.length;
    int m = image[0].length;
    if (sr < 0 || sc < 0 || sr > n || sc > m || image[sr][sc] != targetCol) return;
    image[sr][sc] = newCol;
    for(int i = 0; i < dir.length - 1; i++) recursiveHelper(image, newCol, sr + dir[i] , sc + dir[i+1], targetCol);
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    if (image[sr][sc] == newColor) return image;
    recursiveHelper(image, newColor, sr, sc, image[sr][sc]);
    return image;
  }
}
