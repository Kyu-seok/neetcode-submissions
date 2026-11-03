class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = nums[0];

        int l = 1;
        int r = 1;
        int k = 1;

        while (r < nums.length && l < nums.length) {
            while (r < nums.length && nums[r] <= prev) {
                r++;
            }
            if (r >= nums.length) break;
            // System.out.println("l : " + l + ", r : " + r);

            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            prev = nums[l];
            r++;
            l++;
            k++;
        }
        
        // System.out.println(k);

        return k;
    }
}