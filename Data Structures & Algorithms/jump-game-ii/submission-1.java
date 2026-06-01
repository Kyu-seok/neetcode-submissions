class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length - 1) {
            int furthest = 0;

            while (left <= right) {
                furthest = Math.max(furthest, left + nums[left]);
                left++;
            }

            jumps++;
            right = furthest;
        }

        return jumps;
    }
}
