class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSubarraySum = nums[0];
        int minSubarraySum = nums[0];

        int currMaxSum = 0;
        int currMinSum = 0;
        int total = 0;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            currMaxSum = Math.max(currMaxSum + num, num);
            currMinSum = Math.min(currMinSum + num, num);

            maxSubarraySum = Math.max(maxSubarraySum, currMaxSum);
            minSubarraySum = Math.min(minSubarraySum, currMinSum);

            total += num;
        }

        return (maxSubarraySum > 0) ? Math.max(maxSubarraySum, total - minSubarraySum) : maxSubarraySum;

    }
}