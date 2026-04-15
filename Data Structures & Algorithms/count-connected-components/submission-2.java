class Solution {
    class UnionFind {
        int[] sizes;
        int[] id;
        int numComponents;

        public UnionFind(int n) {
            this.sizes = new int[n];
            Arrays.fill(sizes, 1);

            this.id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
            }

            this.numComponents = n;
        }

        public int find(int p) {
            int root = p;
            while (root != id[root]) {
                root = id[root];
            }

            // Path compression
            while (id[p] != root) {
                int next = id[p];
                id[p] = root;
                p = next;
            }

            return root;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return;

            if (sizes[rootP] > sizes[rootQ]) {
                id[rootQ] = rootP;
                sizes[rootP] += sizes[rootQ];
                sizes[rootQ] = 0;
            } else {
                id[rootP] = rootQ;
                sizes[rootQ] += sizes[rootP];
                sizes[rootP] = 0;
            }

            numComponents--;
        }

        public int getNumComponents() {
            return this.numComponents;
        }
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.getNumComponents();
    }
}
