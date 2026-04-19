class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            int num1 = c1 - '0';

            int count = 0;
            if (num1 != 0) {
                count += (i - 1 < 0) ? 1 : dp[i - 1];
            }

            if (i > 0) {
                char c2 = s.charAt(i - 1);
                int num2 = c2 - '0';
                int twoDigit = num2 * 10 + num1;

                if (10 <= twoDigit && twoDigit <= 26) {
                    count += (i - 2 < 0) ? 1 : dp[i - 2];
                }
            }

            dp[i] = count;
        }

        return dp[s.length() - 1];
    }
}
