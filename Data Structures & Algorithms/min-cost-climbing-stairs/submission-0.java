class Solution {
    
    int[] cost;
    int[] cache;

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        this.cost = cost;
        this.cache = new int[n + 1];
        Arrays.fill(cache, -1);

        return dp(n);
    }

    private int dp(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }

        if (cache[n] != -1) {
            return cache[n];
        }

        cache[n] = Math.min(dp(n - 1) + cost[n - 1], dp(n - 2) + cost[n - 2]);
        return cache[n];
    }
}
