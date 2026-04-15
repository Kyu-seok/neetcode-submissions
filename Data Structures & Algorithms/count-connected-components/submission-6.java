class Solution {
    class UnionFind {
        int[] parent;
        int[] size;
        int components;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            this.size = new int[n];
            Arrays.fill(size, 1);

            this.components = n;
        }

        public int find(int p) {
            if (p == parent[p]) return p;

            return parent[p] = find(parent[p]);
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
