class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, target);
    }

    private int dfs(int[] nums, int i, int rem) {
        if (i == nums.length && rem == 0) return 1;
        if (i >= nums.length) return 0;

        return dfs(nums, i + 1, rem + nums[i]) + dfs(nums, i + 1, rem - nums[i]);
    }
}
