class Solution {
    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];

        String result = s.substring(0, 1);
        int maxLength = 1;

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        for (int start = s.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end < s.length(); end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start == 1 || dp[start + 1][end - 1] != 0) {
                        dp[start][end] = 2 + dp[start + 1][end - 1];
                        if (dp[start][end] > maxLength) {
                            maxLength = dp[start][end];
                            result = s.substring(start, end + 1);
                        }
                    }
                }
            }
        }

        return result;
    }
}
