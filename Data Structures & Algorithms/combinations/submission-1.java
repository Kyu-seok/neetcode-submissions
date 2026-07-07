class Solution {

    List<List<Integer>> result = new ArrayList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.result = new ArrayList<>();
        this.n = n;
        this.k = k;

        backtrack(new ArrayList<>(), 1);

        return result;
    }

    private void backtrack(List<Integer> list, int i) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j <= n; j++) {
            list.add(j);
            backtrack(list, j + 1);
            list.remove(list.size() - 1);
        }
    }
}