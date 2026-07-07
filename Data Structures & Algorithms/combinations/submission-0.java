class Solution {

    List<List<Integer>> result = new ArrayList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.result = new ArrayList<>();
        this.n = n;
        this.k = k;

        // for (int i = 1; i <= n; i++) {
        //     backtrack(new ArrayList<>(), new HashSet<>(), i);
        // }
        backtrack(new ArrayList<>(), new HashSet<>(), 1);

        return result;
    }

    private void backtrack(List<Integer> list, Set<Integer> set, int i) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j <= n; j++) {
            list.add(j);
            backtrack(list, set, j + 1);
            list.remove(list.size() - 1);
        }
    }
}