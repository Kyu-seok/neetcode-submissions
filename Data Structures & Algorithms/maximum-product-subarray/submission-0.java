class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int currMax = 1;
        int currMin = 1;

        for (int num : nums) {
            int newMax = Math.max(currMax * num, Math.max(currMin * num, num));
            int newMin = Math.min(currMax * num, Math.min(currMin * num, num));

            currMax = newMax;
            currMin = newMin;

            result = Math.max(result, currMax);
        }

        return result;
    }
}
