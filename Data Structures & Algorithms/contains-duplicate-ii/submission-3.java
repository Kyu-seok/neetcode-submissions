class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        int l = 0;
        int r = 0;

        while (r < nums.length && r <= k) {
            int num = nums[r];
            if (set.contains(num)) return true;
            set.add(num);
            r++;
        }

        while (r < nums.length) {
            set.remove(nums[l]);
            l++;
            int num = nums[r];
            if (set.contains(num)) return true;
            set.add(num);
            r++;
        }

        return false;
    }
}