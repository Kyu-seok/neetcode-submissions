class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int val = grid[r][c];
                if (val == 0) {
                    queue.offer(new int[] {r, c});
                } 
            }
        }

        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] <= grid[x][y] + 1) continue;

                grid[nx][ny] = grid[x][y] + 1;
                queue.offer(new int[] {nx, ny});
            }
        }

    }
}
