class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;
        int sum = 0;

        while (r < nums.length) {
            sum += nums[r];
            r++;

            while (sum >= target) {
                minLength = Math.min(minLength, r - l);
                sum -= nums[l];
                l++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}