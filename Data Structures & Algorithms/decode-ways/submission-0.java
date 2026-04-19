class Solution {
    int[] cache;
    String s;

    public int numDecodings(String s) {
        this.s = s;
        this.cache = new int[s.length()];

        return dp(s.length() - 1);
    }

    private int dp(int n) {
        // 1 ~ 26
        if (n < 0) return 1;
        if (cache[n] != 0) return cache[n];
        char c1 = s.charAt(n);
        int num1 = c1 - '0';

        int count = 0;

        if (num1 != 0) {
            count += dp(n - 1);
        }

        if (n >= 1) {
            char c2 = s.charAt(n - 1);
            int num2 = c2 - '0';

            int twoDigit = num2 * 10 + num1;

            if (10 <= twoDigit && twoDigit <= 26) {
                count += dp(n - 2);
            }
        }

        return cache[n] = count;
    }
}
