class Solution {
    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];

        return dp(memo, nums, nums.length - 1);
    }

    private int dp(Integer[] memo, int[] nums, int i) {
        if (i < 0) return 0;
        if (memo[i] != null) return memo[i];

        return memo[i] = Math.max(
            dp(memo, nums, i - 1),
            dp(memo, nums, i - 2) + nums[i]
        );
    }
}
