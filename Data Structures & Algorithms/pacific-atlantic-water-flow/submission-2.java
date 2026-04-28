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
            dfs(pacific, r, 0, 0);
            dfs(atlantic, r, n - 1, 0);
        }

        for (int c = 0; c < n; c++) {
            dfs(pacific, 0, c, 0);
            dfs(atlantic, m - 1, c, 0);
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

    private void dfs(boolean[][] ocean, int r, int c, int prevLevel) {
        if (r < 0 || c < 0 || r >= m || c >= n || ocean[r][c]) return;
        if (heights[r][c] < prevLevel) return;
        ocean[r][c] = true;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(ocean, nr, nc, heights[r][c]);
        }
    }
}
