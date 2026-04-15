class Solution {

    int[] nums;
    int[] cache;

    public int rob(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        this.cache = new int[n];

        Arrays.fill(cache, -1);

        return dp(n - 1);
    }

    private int dp(int n) {
        if (n < 0) return 0;
        if (n == 0) return nums[0];
        if (cache[n] != -1) return cache[n];

        cache[n] = Math.max(dp(n - 2) + nums[n], dp(n - 1));
        return cache[n];
    }
}
