class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int minute = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    count++;
                } else if (grid[r][c] == 2) {
                    queue.offer(new int[] {r, c});
                }
            }
        }

        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean rottedThisMin = false;

            for (int i = 0; i < size; i++) {
                int[] axis = queue.poll();
                int r = axis[0];
                int c = axis[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                    if (grid[nr][nc] != 1) continue;
                    queue.offer(new int[] {nr, nc});
                    grid[nr][nc] = 2;
                    rottedThisMin = true;
                    count--;
                }
            }

            if (rottedThisMin) minute++;
            // if (count == 0) break;
        }

        return (count == 0) ? minute : -1;
    }
}
