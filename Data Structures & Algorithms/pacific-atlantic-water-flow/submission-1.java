class Solution {

    int m;
    int n;
    int[][] heights;
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int r = 0; r < m; r++) {
            pacific[r][0] = true;
            atlantic[r][n - 1] = true;
        }

        for (int c = 0; c < n; c++) {
            pacific[0][c] = true;
            atlantic[m - 1][c] = true;
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c]) {
                    dfs(pacific, r, c);
                }

                if (atlantic[r][c]) {
                    dfs(atlantic, r, c);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }

        return result;
    }

    private void dfs(boolean[][] ocean, int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n) return;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < 0 || nc < 0 || nr >= m || nc >= n || ocean[nr][nc]) continue;
            if (heights[nr][nc] < heights[r][c]) continue;
            ocean[nr][nc] = true;
            dfs(ocean, nr, nc);
        }
    }
}
