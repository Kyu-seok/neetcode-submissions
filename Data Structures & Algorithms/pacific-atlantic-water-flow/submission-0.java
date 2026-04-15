class Solution {

    int m;
    int n;
    int[][] heights;
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.m = heights.length;
        this.n = heights[0].length;
        this.heights = heights;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int c = 0; c < n; c++) {
            dfs(pacific, 0, c);
        }

        for (int r = 0; r < m; r++) {
            dfs(pacific, r, 0);
        }

        for (int c = 0; c < n; c++) {
            dfs(atlantic, m - 1, c);
        }

        for (int r = 0; r < m; r++) {
            dfs(atlantic, r, n - 1);
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
        ocean[r][c] = true;

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
            if (ocean[nr][nc]) continue;

            if (heights[r][c] <= heights[nr][nc]) {
                dfs(ocean, nr, nc);
            }
        }
    }
}
