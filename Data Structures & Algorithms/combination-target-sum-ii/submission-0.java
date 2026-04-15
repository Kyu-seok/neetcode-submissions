class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<>();

        backtrack(set, candidates, result, list, target, 0);

        return result;
    }

    private void backtrack(Set<List<Integer>> set, int[] candidates, List<List<Integer>> result, List<Integer> list, int rem, int start) {
        if (start == candidates.length);
        if (rem < 0) return;
        if (rem == 0) {
            List<Integer> newList = new ArrayList<Integer>(list);
            if (!set.contains(newList)) {
                result.add(newList);
                set.add(newList);
            }
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(set, candidates, result, list, rem - candidates[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
