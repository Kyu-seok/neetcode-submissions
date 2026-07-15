class Solution {

    Integer[][] memo;
    String word1;
    String word2;

    public int minDistance(String word1, String word2) {
        this.memo = new Integer[word1.length()][word2.length()];
        this.word1 = word1;
        this.word2 = word2;

        return dp(0, 0);
    }

    private int dp(int i, int j) {
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;
        if (memo[i][j] != null) return memo[i][j];

        if (word1.charAt(i) == word2.charAt(j)) {
            return memo[i][j] = dp(i + 1, j + 1);
        }

        int replace = 1 + dp(i + 1, j + 1);
        int delete = 1 + dp(i + 1, j);
        int insert = 1 + dp(i, j + 1);

        return memo[i][j] = Math.min(replace, Math.min(delete, insert));
    }
}
