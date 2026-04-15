/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) { 
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node currentCopy;

            if (map.containsKey(current)) {
                currentCopy = map.get(current);
            } else {
                currentCopy = new Node(current.val);
                map.put(current, currentCopy);
            }

            for (Node neighbor : current.neighbors) {
                Node neighborCopy;
                if (map.containsKey(neighbor)) {
                    neighborCopy = map.get(neighbor);
                } else {
                    neighborCopy = new Node(neighbor.val);
                }

                currentCopy.neighbors.add(neighborCopy);

                if (!map.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    map.put(neighbor, neighborCopy);
                }
            }

        }

        return map.get(node);
    }
}