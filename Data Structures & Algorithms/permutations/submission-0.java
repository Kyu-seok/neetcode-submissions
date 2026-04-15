class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        backtrack(nums, result, list, set, 0);

        return result;
    }

    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> list, Set<Integer> set, int start) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                list.add(nums[i]);
                backtrack(nums, result, list, set, start + 1);
                list.remove(list.size() - 1);
                set.remove(nums[i]);
            }
        }
    }
}
