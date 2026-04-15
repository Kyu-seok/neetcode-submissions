class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[] {i, j, 0});
                }
            }
        }

        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int i = arr[0];
            int j = arr[1];
            int val = arr[2];

            grid[i][j] = Math.min(val, grid[i][j]);

            for (int[] dir : dirs) {
                int r = i + dir[0];
                int c = j + dir[1];
                int nextVal = val + 1;

                if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == -1 || grid[r][c] < nextVal) continue;

                queue.add(new int[] {r, c, nextVal});
            }
        }
        
    }
}
