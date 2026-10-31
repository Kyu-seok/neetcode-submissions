class Solution {
    public int maxProfit(int[] prices) {
        int cash = 0;
        int hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int prevCash = cash;
            int prevHold = hold;

            cash = Math.max(prevCash, prevHold + prices[i]);
            hold = Math.max(prevHold, prevCash - prices[i]);
        }

        return cash;
    }
}