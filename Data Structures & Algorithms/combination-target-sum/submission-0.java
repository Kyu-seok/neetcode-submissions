class Solution {
    Set<List<Integer>> set;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        backtrack(nums, result, list, target, 0, 0);

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> list, int target, int sum, int start) {
        if (sum > target) return;
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, result, list, target, sum + nums[i], i);
            list.remove(list.size() - 1);
        }
    }
}
