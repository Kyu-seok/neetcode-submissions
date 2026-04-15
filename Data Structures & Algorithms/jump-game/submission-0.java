class Solution {
    public boolean canJump(int[] nums) {

        boolean[] isReachable = new boolean[nums.length];

        dfs(nums, isReachable, 0);

        return isReachable[nums.length - 1];
    }

    private void dfs(int[] nums, boolean[] isReachable, int i) {
        // if (i == nums.length) return;
        isReachable[i] = true;

        for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
            dfs(nums, isReachable, j);
        }
    }
}
