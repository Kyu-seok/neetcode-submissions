class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(new boolean[grid.length][grid[0].length], grid, i, j, 0);
                }
            }
        }
    }

    private void dfs(boolean[][] visited, int[][] grid, int i, int j, int dis) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1 || visited[i][j]) return;
        
        visited[i][j] = true;
        grid[i][j] = Math.min(grid[i][j], dis);

        dfs(visited, grid, i + 1, j, dis + 1);
        dfs(visited, grid, i - 1, j, dis + 1);
        dfs(visited, grid, i, j + 1, dis + 1);
        dfs(visited, grid, i, j - 1, dis + 1);
    }
}
