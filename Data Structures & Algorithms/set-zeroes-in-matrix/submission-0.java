class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean rowZero = false;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    if (r > 0) {
                        matrix[r][0] = 0;
                        matrix[0][c] = 0;
                    } else {
                        rowZero = true;
                    }
                }
            }
        }

        for (int r = 1; r < m; r++) {
            if (matrix[r][0] == 0) {
                setRowZero(matrix, r);
            }
        }

        for (int c = 1; c < n; c++) {
            if (matrix[0][c] == 0) {
                setColZero(matrix, c);
            }
        }

        if (matrix[0][0] == 0) {
            setColZero(matrix, 0);
        }

        if (rowZero) {
            setRowZero(matrix, 0);
        }

    }

    private void setRowZero(int[][] matrix, int r) {
        for (int c = 0; c < matrix[0].length; c++) {
            matrix[r][c] = 0;
        }
    }

    private void setColZero(int[][] matrix, int c) {
        for (int r = 0; r < matrix.length; r++) {
            matrix[r][c] = 0;
        }
    }
}
