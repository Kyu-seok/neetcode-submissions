class Solution {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> set = new HashSet<>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            int count = 0;
            if (set.contains(a)) count++;
            if (set.contains(b)) count++;

            if (count == 2) return false;

            set.add(a);
            set.add(b);
        }

        return true;
    }
}
