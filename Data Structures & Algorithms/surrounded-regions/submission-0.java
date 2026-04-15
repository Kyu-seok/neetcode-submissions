class Solution {

    int m;
    int n;
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        this.m = board.length;
        this.n = board[0].length;

        for (int r = 0; r < m; r++) {
            dfs(board, r, 0);
            dfs(board, r, n - 1);
        }

        for (int c = 0; c < n; c++) {
            dfs(board, 0, c);
            dfs(board, m - 1, c);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] != 'O') return;

        board[r][c] = '#';

        for (int[] dir : directions) {
            dfs(board, r + dir[0], c + dir[1]);
        }
    }
}
