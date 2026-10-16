class Solution {
    public int climbStairs(int n) {
        Integer[] cache = new Integer[n + 1];

        return dp(cache, n);
    }

    private int dp(Integer[] cache, int i) {
        if (i <= 2) return i;
        if (cache[i] != null) return cache[i];
  
        return cache[i] = dp(cache, i - 1) + dp(cache, i - 2);
    }
}
