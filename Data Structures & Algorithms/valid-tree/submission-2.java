class Solution {
    class Node {
        int val;
        List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<Node>();
        }
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return true;
        
        Map<Integer, Node> map = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (!map.containsKey(a)) {
                map.put(a, new Node(a));
            }

            if (!map.containsKey(b)) {
                map.put(b, new Node(b));
            }

            Node nodeA = map.get(a);
            Node nodeB = map.get(b);

            nodeA.neighbors.add(nodeB);
            nodeB.neighbors.add(nodeA);
        }

        Set<Node> visited = new HashSet<>();
        return dfs(map.get(edges[0][0]), visited, null) && (visited.size() == n);
    }

    private boolean dfs(Node root, Set<Node> visited, Node prev) {
        if (visited.contains(root)) return false;
        visited.add(root);

        for (Node next : root.neighbors) {
            if (next != prev) {
                if (!dfs(next, visited, root)) return false;
            }
        }

        return true;
    }


}
