class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        Map<String, Integer> emailToAccount = new HashMap<>();

        // Construct correct UF
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);

                if (!emailToAccount.containsKey(email)) {
                    emailToAccount.put(email, i);
                } else {
                    uf.union(i, emailToAccount.get(email));
                }
            }
        }

        // loop through the accounts, and find each root id and make Map<Integer, Set<String>> hash map
        Map<Integer, Set<String>> rootToEmails = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = uf.find(i);

            if (!rootToEmails.containsKey(root)) {
                rootToEmails.put(root, new HashSet<>());
            }

            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                rootToEmails.get(root).add(email);
            }
        }

        // Loop through the constructed rootToEmails map and create final output
        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<Integer, Set<String>> entry : rootToEmails.entrySet()) {
            int root = entry.getKey();
            String name = accounts.get(root).get(0);

            List<String> list = new ArrayList<>(entry.getValue());
            Collections.sort(list);
            list.add(0, name);

            result.add(list);
        }

        return result;
    }

    public class UnionFind {

        int[] parent;
        int[] size;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) return;

            if (size[rootA] > size[rootB]) {
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            } else {
                parent[rootA] = rootB;
                size[rootB] += size[rootA];
            }
        }

        public int find(int a) {
            if (a != parent[a]) {
                parent[a] = find(parent[a]);
            }

            return parent[a];
        }
    }
}