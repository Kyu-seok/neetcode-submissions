class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : times) {
            int source = edge[0];
            int target = edge[1];
            int weight = edge[2];

            graph[source].add(new int[] {target, weight});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        minHeap.offer(new int[] {k, 0});

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int node = current[0];
            int time = current[1];

            if (dist[node] < time) continue;

            for (int[] edge : graph[node]) {
                int next = edge[0];
                int weight = edge[1];

                int newTime = time + weight;

                if (newTime < dist[next]) {
                    dist[next] = newTime;
                    minHeap.offer(new int[] {next, newTime});
                }
            }
        }

        int result = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, dist[i]);
        }

        return result;
    }
}
