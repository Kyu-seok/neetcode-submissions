class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] times = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(times[i], Integer.MAX_VALUE);
        }

        times[0][0] = grid[0][0];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        minHeap.offer(new int[] {0, 0, grid[0][0]});

        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();

            int r = curr[0];
            int c = curr[1];
            int time = curr[2];

            if (time > times[r][c]) continue;
            if (r == n - 1 && c == n - 1) return time;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

                int newTime = Math.max(time, grid[nr][nc]);
                if (newTime < times[nr][nc]) {
                    times[nr][nc] = newTime;
                    minHeap.offer(new int[] {nr, nc, newTime});
                }
            }

        }

        return 0;
    }
}
