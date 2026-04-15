class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> rowSet = new HashSet<>();
        Set<Character> colSet = new HashSet<>();
        Set<Character> boxSet = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            rowSet.clear();

            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                if (rowSet.contains(ch)) return false;
                rowSet.add(ch);
            }
        }

        for (int c = 0; c < 9; c++) {
            colSet.clear();

            for (int r = 0; r < 9; r++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                if (colSet.contains(ch)) return false;
                colSet.add(ch);
            }
        }

        for (int r = 0; r < 9; r = r + 3) {
            for (int c = 0; c < 9; c = c + 3) {
                boxSet.clear();
                for (int i = r; i < r + 3; i++) {
                    for (int j = c; j < c + 3; j++) {
                        char ch = board[i][j];
                        if (ch == '.') continue;
                        if (boxSet.contains(ch)) return false;
                        boxSet.add(ch);
                    }
                }
            }
        }

        return true;
    }
}
