package beray.leetcode.AlgorithmStudies.Day7;
// https://leetcode.com/problems/flood-fill/
public class FloodFill {
  public void recursiveHelper(int[][] image, int currColor, int newColor, int sr, int sc) {
    int lenMat = image.length;
    int lenCol = image[0].length;
    if (image[sr][sc] == currColor) {
      image[sr][sc] = newColor;
      if (sr > 0) { // move up
        recursiveHelper(image, currColor, newColor, --sr, sc);
      } else if (sc < lenCol) {
        recursiveHelper(image, currColor, newColor, sr, ++sc);
      } else if (sr < lenMat) {
        recursiveHelper(image, currColor, newColor, ++sr, sc);
      } else if (sc > 0) {
        recursiveHelper(image, currColor, newColor, sr, --sc);
      }
    }
  }

  public int[][] recursiveFloodFill(int[][] image, int sr, int sc, int newColor) {
    int currentColor = image[sr][sc];
    if (currentColor == newColor) return image;
    recursiveHelper(image, currentColor, newColor, sr, sc);
    return image;
  }
}
