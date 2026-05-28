class Solution {
    public long minEnd(int n, int x) {
        long result = x;

        n--;

        int bit = 0;

        while (n != 0) {
            if ((result & (1L << bit)) == 0) {
                if ((n & 1) == 1) {
                    result = result | (1L << bit);
                }
                n >>= 1;
            }
            bit++;
        }

        return result;
    }
}