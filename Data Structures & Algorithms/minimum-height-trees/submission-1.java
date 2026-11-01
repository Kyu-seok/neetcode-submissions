class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> roots = new ArrayList<>();
        int minHeight = Integer.MAX_VALUE;

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }

            graph.get(u).add(v);

            if (!graph.containsKey(v)) {
                graph.put(v, new ArrayList<>());
            }

            graph.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {
            int height = getHeight(graph, i, new HashSet<>());

            if (height < minHeight) {
                roots = new ArrayList<>();
                minHeight = height;
            }

            if (height == minHeight) {
                roots.add(i);
            }
        }

        return roots;
    }

    private int getHeight(Map<Integer, List<Integer>> graph, int node, Set<Integer> visited) {
        if (visited.contains(node)) return 0;
        visited.add(node);

        List<Integer> edges = graph.get(node);
        if (edges == null) return 0;

        int height = 0;

        for (int next : edges) {
            height = Math.max(height, getHeight(graph, next, visited));
        }

        return height + 1;
    }
}