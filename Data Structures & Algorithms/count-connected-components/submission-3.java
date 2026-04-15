class Solution {
    class UnionFind {
        int[] size;
        int[] parent;
        int components;

        public UnionFind(int n) {
            this.size = new int[n];
            Arrays.fill(size, 1);

            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            this.components = n;
        }

        public int find(int p) {
            int root = p;
            while (root != parent[root]) {
                root = parent[root];
            }

            // Path compression
            while (parent[p] != root) {
                int next = parent[p];
                parent[p] = root;
                p = next;
            }

            return root;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return;

            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }

            components--;
        }

        public int getComponents() {
            return this.components;
        }
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.getComponents();
    }
}
