class Solution {
    public int uniquePaths(int m, int n) {
        Integer[][] memo = new Integer[m][n];

        return dfs(memo, m - 1, n - 1);
    }

    private int dfs(Integer[][] memo, int r, int c) {
        if (r < 0 || c < 0) return 0;
        if (r == 0 && c == 0) return 1;
        if (memo[r][c] != null) return memo[r][c];

        return memo[r][c] = dfs(memo, r - 1, c) + dfs(memo, r, c - 1);
    }
}
