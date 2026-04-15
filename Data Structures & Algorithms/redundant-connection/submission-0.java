class Solution {
    class UnionFind {
        int[] size;
        int[] parent;

        public UnionFind(int n) {
            this.size = new int[n];
            Arrays.fill(size, 1);

            this.parent = new int[n];
            for (int i = 1; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            if (p == parent[p]) return p;

            return parent[p] = find(parent[p]);
        }

        public boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return false;

            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }

            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length + 1);

        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) return edge;
        }

        return null;
    }
}
