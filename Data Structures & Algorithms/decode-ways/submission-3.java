class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = s.charAt(i - 1) - '0';
            int twoDigit = (s.charAt(i - 2) - '0') * 10 + oneDigit;

            if (oneDigit != 0) {
                dp[i] += dp[i - 1];
            }

            if (10 <= twoDigit && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}
