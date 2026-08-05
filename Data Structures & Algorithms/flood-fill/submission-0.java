class Solution {

    int m;
    int n;
    int[][] image;
    boolean[][] visited;
    int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.m = image.length;
        this.n = image[0].length;
        this.image = image;
        this.visited = new boolean[m][n];

        dfs(sr, sc, image[sr][sc], color);

        return image;
    }

    private void dfs(int r, int c, int originalColor, int changeColor) {
        if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || image[r][c] != originalColor) return;

        visited[r][c] = true;
        image[r][c] = changeColor;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            dfs(nr, nc, originalColor, changeColor);
        }
    }
}