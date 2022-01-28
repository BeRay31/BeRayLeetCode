package beray.leetcode.AlgorithmStudiesII.Day6;
// https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvince {
  public void exploreProvince(int[][] isConnected, boolean[][] isVisited, int from) {
    for (int i = 0; i < isConnected[from].length; i++) {
      if (!isVisited[from][i] && isConnected[from][i] == 1) {
        isVisited[from][i] = true;
        exploreProvince(isConnected, isVisited, i);
      }
    }
  }

  public int findCircleNum(int[][] isConnected) {
    int count = 0;
    boolean[][] isVisited = new boolean[isConnected.length][isConnected[0].length];
    
    for (int i = 0; i < isConnected.length; i++) {
      for (int j = 0; j < isConnected[i].length; j++) {
        if (isVisited[i][j]) continue;
        else {
          if (isConnected[i][j] == 1) {
            exploreProvince(isConnected, isVisited, i);
            count++;
          }
          else isVisited[i][j] = true;
        }
      }
    }
    return count;
  }
}
