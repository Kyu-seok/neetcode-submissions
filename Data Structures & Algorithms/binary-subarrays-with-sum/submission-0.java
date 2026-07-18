class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {

        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;
        int count = 0;
        int curr = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            curr += nums[r];
            while (curr > goal) {
                curr -= nums[l++];
            }

            count += r - l + 1;
        }

        return count;
    }
}