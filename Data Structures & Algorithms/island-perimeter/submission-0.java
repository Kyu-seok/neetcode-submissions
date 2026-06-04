class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int perimeter = 0;
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int r = i + dir[0];
                        int c = j + dir[1];

                        if (r >= m || c >= n || r < 0 || c < 0 || grid[r][c] == 0) {
                            perimeter++;
                        }
                    }
                }
            }
        }

        return perimeter;
    }
}