class Solution {

    char[][] board;
    int m;
    int n;
    String word;
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.word = word;
        this.visited = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (backtrack(r, c, 0)) return true;
            }
        }

        return false;
    }

    private boolean backtrack(int r, int c, int i) {
        if (i >= word.length()) return true;
        if (r < 0 || c < 0 || r >= m || c >= n) return false;
        if (visited[r][c]) return false;

        visited[r][c] = true;

        if (board[r][c] == word.charAt(i)) {
            for (int[] dir : dirs) {
                if (backtrack(r + dir[0], c + dir[1], i + 1)) return true;
            }
        }

        visited[r][c] = false;

        return false;
    }
}
