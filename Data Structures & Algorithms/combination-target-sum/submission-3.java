class Solution {


    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, result, new ArrayList<>(), target, 0);

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> list, int rem, int start) {
        if (rem < 0) return;
        if (rem == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, result, list, rem - nums[i], i);
            list.remove(list.size() - 1);
        }
    }
}
