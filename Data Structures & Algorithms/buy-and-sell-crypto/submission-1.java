class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currMin = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int num = prices[i];
            if (num > currMin) {
                maxProfit = Math.max(maxProfit, num - currMin);
            } else {
                currMin = num;
            }
        }

        return maxProfit;
    }
}
