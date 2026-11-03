class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 1;

        for (int r = 1; r < nums.length; r++) {
            if (nums[r] != nums[l - 1]) {
                nums[l] = nums[r];
                l++;
            }
        }

        return l;
    }
}