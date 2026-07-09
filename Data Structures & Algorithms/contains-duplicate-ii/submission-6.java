class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        int l = 0;
        int r = 0;

        while (r < nums.length && r <= k) {
            if (set.contains(nums[r])) return true;
            set.add(nums[r++]);
        }
        
        while (r < nums.length) {
            set.remove(nums[l++]);
            if (set.contains(nums[r])) return true;
            set.add(nums[r++]);
        }

        return false;
    }
}