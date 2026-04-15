class Solution {
    public boolean validTree(int n, int[][] edges) {
        // 1. Must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        // 2. Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 3. DFS
        boolean[] visited = new boolean[n];
        if (!dfs(0, -1, graph, visited)) return false;

        // 4. Check connectivity
        for (boolean v : visited) {
            if (!v) return false;
        }

        return true;
    }

    private boolean dfs(int node, int parent,
                        List<List<Integer>> graph,
                        boolean[] visited) {

        if (visited[node]) return false;

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (neighbor == parent) continue;
            if (!dfs(neighbor, node, graph, visited)) return false;
        }

        return true;
    }
}
