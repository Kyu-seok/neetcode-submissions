class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int maxSum = 0;
        for (int num : nums) {
            maxSum += num;
        }

        Integer[][] cache = new Integer[nums.length][2 * maxSum + 1];
        
        return dfs(cache, nums, 0, target);
    }

    private int dfs(Integer[][] cache, int[] nums, int i, int rem) {
        if (i == nums.length && rem == 0) return 1;
        if (i >= nums.length) return 0;
        if (rem >= 0 && cache[i][rem] != null) return cache[i][rem];
        if (rem < 0 && cache[i][cache[0].length + rem] != null) return cache[i][cache[0].length + rem];

        int result = dfs(cache, nums, i + 1, rem + nums[i]) + dfs(cache, nums, i + 1, rem - nums[i]);

        if (rem >= 0) {
            cache[i][rem] = result;
        } else {
            cache[i][cache[0].length + rem] = result;
        }

        return result;
    }
}
