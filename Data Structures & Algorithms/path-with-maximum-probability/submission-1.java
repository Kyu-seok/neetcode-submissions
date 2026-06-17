class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<double[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int nodeA = edge[0];
            int nodeB = edge[1];

            double prob = succProb[i];

            graph[nodeA].add(new double[] {nodeB, prob});
            graph[nodeB].add(new double[] {nodeA, prob});
        }

        double[] probs = new double[n];
        Arrays.fill(probs, 0);
        probs[start_node] = 1;

        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        maxHeap.offer(new double[] {start_node, 1});

        while (!maxHeap.isEmpty()) {
            double[] curr = maxHeap.poll();
            int currNode = (int) curr[0];
            double currProb = curr[1];

            if (currNode == end_node) {
                return currProb;
            }

            for (double[] edge : graph[currNode]) {
                int nextNode = (int) edge[0];
                double nextProb = edge[1];
                double newProb = currProb * nextProb;

                // TODO : Think of < or <=
                if (probs[nextNode] < nextProb) {
                    probs[nextNode] = nextProb;
                    maxHeap.offer(new double[] {nextNode, newProb});
                }
            }
        }

        return 0;
    }
}