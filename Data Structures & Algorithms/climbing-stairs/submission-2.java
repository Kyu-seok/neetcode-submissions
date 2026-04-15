class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[31];
        cache[1] = 1;
        cache[2] = 2;

        return dp(cache, n);
    }

    private int dp(int[] cache, int n) {
        if (cache[n] != 0) {
            return cache[n];
        }

        cache[n] = dp(cache, n - 1) + dp(cache, n - 2);
        return cache[n];
    }
}
