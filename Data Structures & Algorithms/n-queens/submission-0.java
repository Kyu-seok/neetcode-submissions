class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(result, board, 0);

        return result;
    }

    private void backtrack(List<List<String>> result, char[][] board, int row) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for (char[] charArr : board) {
                list.add(new String(charArr));
            }
            result.add(list);
            return;
        }

        for (int i = 0; i < board[0].length; i++) {
            if (isValid(board, row, i)) {
                board[row][i] = 'Q';
                backtrack(result, board, row + 1);
                board[row][i] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        if (board[row][col] == 'Q') return false;

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }
}
