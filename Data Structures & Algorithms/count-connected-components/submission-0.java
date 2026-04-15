class Solution {
    class Node {
        int val;
        List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public int countComponents(int n, int[][] edges) {
        
        Map<Integer, Node> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new Node(i));
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            Node nodeA = map.get(a);
            Node nodeB = map.get(b);

            nodeA.neighbors.add(nodeB);
            nodeB.neighbors.add(nodeA);
        }

        Set<Node> visited = new HashSet<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            Node current = map.get(i);
            if (visited.contains(current)) continue;

            count++;
            dfs(visited, current);
        }

        return count;
    }

    private void dfs(Set<Node> visited, Node node) {
        if (node == null) return;
        if (visited.contains(node)) return;

        visited.add(node);

        for (Node next : node.neighbors) {
            dfs(visited, next);
        }
    }
}
