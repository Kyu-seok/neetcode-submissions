class Solution {

    int[] nums;
    Set<Set<Integer>> resultSet;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        resultSet = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        resultSet.add(set);

        backtrack(set, 0);

        List<List<Integer>> result = new ArrayList<>();
        for (Set<Integer> subSet : resultSet) {
            result.add(new ArrayList<Integer>(subSet));
        }

        return result;
    }

    private void backtrack(Set<Integer> set, int i) {
        resultSet.add(new HashSet<Integer>(set));

        for (int j = i; j < nums.length; j++) {
            set.add(nums[j]);
            backtrack(set, j + 1);
            set.remove(nums[j]);
        }

    }
}
