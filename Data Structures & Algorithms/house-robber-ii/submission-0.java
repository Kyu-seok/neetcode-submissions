class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);

        return dp(nums, cache, start, end);
    }

    private int dp(int[] nums, int[] cache, int start, int n) {
        if (n < start) return 0;
        if (n == start) return nums[start];
        if (cache[n] != -1) return cache[n];

        return cache[n] = Math.max(dp(nums, cache, start, n - 2) + nums[n], 
                                   dp(nums, cache, start, n - 1));
    }
}
