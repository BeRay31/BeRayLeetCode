package beray.leetcode.AlgorithmStudiesII.Day11;
// https://leetcode.com/problems/word-search/
public class WordSearch {
  int[] dir = new int[]{1, 0, -1, 0, 1};
  public boolean isSuccessorExist(char[][] board, char[] word, int targetIndex, boolean[][] visited, int row, int col) {
    boolean sol = false;
    if (word.length == targetIndex && board[row][col] == word[targetIndex - 1]) return true;
    if (targetIndex >= word.length) return false;
    for (int i = 0; i < dir.length - 1; i++) {
      int newRow = row + dir[i];
      int newCol = col + dir[i + 1]; 
      if (newRow < 0 || newCol < 0 || newRow >= board.length || newCol >= board[0].length || visited[newRow][newCol]) continue;
      if (board[newRow][newCol] == word[targetIndex]) {
        visited[newRow][newCol] = true;
        if (targetIndex == word.length - 1) return true;
        sol = sol || isSuccessorExist(board, word, targetIndex + 1, visited, newRow , newCol);
        visited[newRow][newCol] = false;
        if (sol) return true;
      }
    }
    return sol;
  }

  public boolean exist(char[][] board, String word) {
    boolean sol = false;
    char[] wordArr = word.toCharArray();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == wordArr[0]) {
          boolean[][] visited = new boolean[board.length][board[0].length];
          visited[i][j] = true;
          sol = sol || isSuccessorExist(board, wordArr, 1, visited, i , j);
        }
        if (sol) return sol;
      }
    }
    return sol;
  }
}
