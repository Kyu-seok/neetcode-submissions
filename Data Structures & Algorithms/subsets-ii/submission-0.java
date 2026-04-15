class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(set, nums, list, 0);

        return new ArrayList<List<Integer>>(set);
    }

    private void backtrack(Set<List<Integer>> set, int[] nums, List<Integer> list, int i) {
        set.add(new ArrayList<>(list));

        for (int j = i; j < nums.length; j++) {
            list.add(nums[j]);
            backtrack(set, nums, list, j + 1);
            list.remove(list.size() - 1);
        }
    }
}
