class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[] {r, c});
                }
            }
        }

        int level = 0;
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] axis = queue.poll();
                int r = axis[0];
                int c = axis[1];
                grid[r][c] = Math.min(grid[r][c], level);

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                    if (grid[nr][nc] <= level) continue;

                    queue.offer(new int[] {nr, nc});
                }
            }
            level++;
        }
    }
}
