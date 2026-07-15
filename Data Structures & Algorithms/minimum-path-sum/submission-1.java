class Solution {

    int[][] grid;
    Integer[][] memo;
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        this.grid = grid;
        this.memo = new Integer[m][n];

        return dp(m - 1, n - 1);
    }

    private int dp(int r, int c) {
        if (r < 0 || c < 0) return Integer.MAX_VALUE;
        if (r == 0 && c == 0) return grid[0][0];
        if (memo[r][c] != null) return memo[r][c];

        int best = Math.min(dp(r - 1, c), dp(r, c - 1));
        if (best == Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return memo[r][c] = best + grid[r][c];
    }
}