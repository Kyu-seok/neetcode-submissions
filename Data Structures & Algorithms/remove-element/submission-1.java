class Solution {
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            if (nums[l] == val) {
                nums[l] = nums[r];
                // this could be negelected if the value after do not matter
                // nums[r] = val;
                r--;
            } else {
                l++;
            }
        }

        return l;
    }
}