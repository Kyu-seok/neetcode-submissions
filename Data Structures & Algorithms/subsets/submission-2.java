class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtrack(nums, result, list, 0);

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> list, int i) {
        result.add(new ArrayList<>(list));

        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            backtrack(nums, result, list, j + 1);
            list.remove(list.size() - 1);
        }
    }
}
