class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int r = point[0];
            int c = point[1];

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || grid[nr][nc] != Integer.MAX_VALUE) continue;
                
                grid[nr][nc] = 1 + grid[r][c];
                queue.offer(new int[] {nr, nc});
            }
        }

    }
}
