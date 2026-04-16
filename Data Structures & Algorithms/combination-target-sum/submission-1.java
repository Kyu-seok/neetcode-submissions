class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtrack(nums, result, list, target, 0);

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> list, int rem, int start) {
        if (start == nums.length) return;

        result.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
        }
    }
}
