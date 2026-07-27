class Solution {

    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;

        backtrack(new ArrayList<>(), new boolean[nums.length]);

        return result;
    }

    private void backtrack(List<Integer> list, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            list.add(nums[i]);
            backtrack(list, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}