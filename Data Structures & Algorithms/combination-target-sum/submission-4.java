class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, result, new ArrayList<>(), target, 0);

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> list, int rem, int i) {
        if (i >= nums.length || rem < 0) return;
        if (rem == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            backtrack(nums, result, list, rem - nums[j], j);
            list.remove(list.size() - 1);
        }
    }
}
