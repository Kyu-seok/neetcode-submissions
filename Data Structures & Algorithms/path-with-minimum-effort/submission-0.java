class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] efforts = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }

        efforts[0][0] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        minHeap.offer(new int[] {0, 0, 0});

        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int r = curr[0];
            int c = curr[1];
            int currEffort = curr[2];

            if (efforts[r][c] < currEffort) continue;
            if (r == m - 1 && c == n - 1) return currEffort;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;

                int edgeWeight = Math.abs(heights[r][c] - heights[nr][nc]);
                int newEffort = Math.max(currEffort, edgeWeight);

                if (newEffort < efforts[nr][nc]) {
                    efforts[nr][nc] = newEffort;
                    minHeap.offer(new int[] {nr, nc, newEffort});
                }
            }
        }

        return 0;
    }
}