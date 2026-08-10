class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        Integer[] memo = new Integer[n];

        for (int i = 0; i < n; i++) {
            dp(nums, memo, i);
        }

        return memo[n - 1];
    }

    private int dp(int[] nums, Integer[] memo, int i) {
        if (i < 0) return 0;
        if (memo[i] != null) return memo[i];

        return memo[i] = Math.max(dp(nums, memo, i - 2) + nums[i], dp(nums, memo, i - 1));
    }
}
