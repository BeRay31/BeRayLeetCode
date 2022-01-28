package beray.leetcode.AlgorithmStudiesII.Day8;
// https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegions {
  int[] dir = new int[]{1, 0, -1, 0, 1};
  public void exploreOBoard(char[][] board, boolean[][] isNotFlipped, int row, int col) {
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || isNotFlipped[row][col] || board[row][col] != 'O') return;
    isNotFlipped[row][col] = true;
    for (int i = 0; i < dir.length - 1; i++) {
      exploreOBoard(board, isNotFlipped, row + dir[i], col + dir[i + 1]);
    }
  }

  public void solve(char[][] board) {
    int m = board.length;
    int n = board[0].length;
    if (m <= 2) return;
    boolean[][] isNotFlipped = new boolean[m][n];
    // iterate horizontally
    for (int i = 0; i < n; i++) {
      if (board[0][i] == 'O' && !isNotFlipped[0][i]) exploreOBoard(board, isNotFlipped, 0, i);
      if (board[m - 1][i] == 'O' && !isNotFlipped[m - 1][i]) exploreOBoard(board, isNotFlipped, m - 1, i);
    }
    // iterate vertically
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'O' && !isNotFlipped[i][0]) exploreOBoard(board, isNotFlipped, i, 0);
      if (board[i][n - 1] == 'O' && !isNotFlipped[i][n - 1]) exploreOBoard(board, isNotFlipped, i, n - 1);
    }
    // iterate board and flip
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!isNotFlipped[i][j] && board[i][j] == 'O') board[i][j] = 'X';
      }
    }
  }
}
