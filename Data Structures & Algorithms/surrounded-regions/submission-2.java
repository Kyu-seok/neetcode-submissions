class Solution {

    int m;
    int n;
    char[][] board;
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;

        for (int r = 0; r < m; r++) {
            if (board[r][0] == 'O') {
                dfs(r, 0);
            }
            if (board[r][n - 1] == 'O') {
                dfs(r, n - 1);
            }
        }

        for (int c = 0; c < n; c++) {
            if (board[0][c] == 'O') {
                dfs(0, c);
            }
            if (board[m - 1][c] == 'O') {
                dfs(m - 1, c);
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == '#') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }

    }

    private void dfs(int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] == '#') return;
        if (board[r][c] == 'X') return;

        board[r][c] = '#';

        for (int[] dir : dirs) {
            dfs(r + dir[0], c + dir[1]);
        }
    }
}