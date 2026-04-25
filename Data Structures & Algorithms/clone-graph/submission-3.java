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
        Set<Node> set = new HashSet<>();

        queue.offer(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            set.add(current);
            Node currentCopy;
            if (!map.containsKey(current)) {
                currentCopy = new Node(current.val);
                map.put(current, currentCopy);
            } else {
                currentCopy = map.get(current);
            }

            for (Node child : current.neighbors) {
                Node childCopy;
                if (!map.containsKey(child)) {
                    childCopy = new Node(child.val);
                    map.put(child, childCopy);
                } else {
                    childCopy = map.get(child);
                }
                currentCopy.neighbors.add(childCopy);
                if (!set.contains(child)) {
                    queue.offer(child);
                    set.add(child);
                }
            }
           
        }

        return map.get(node);
    }
}