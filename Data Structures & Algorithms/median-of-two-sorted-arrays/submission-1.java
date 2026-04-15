class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        if (length1 > length2) return findMedianSortedArrays(nums2, nums1);

        int start = 0;
        int end = length1;

        while (start <= end) {
            int partition1 = (start + end) / 2;
            int partition2 = ((length1 + length2 + 1) / 2) - partition1;

            int left1 = (partition1 - 1 < 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int left2 = (partition2 - 1 < 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];

            int right1 = (partition1 >= length1) ? Integer.MAX_VALUE : nums1[partition1];
            int right2 = (partition2 >= length2) ? Integer.MAX_VALUE : nums2[partition2];

            if (left1 <= right2 && left2 <= right1) {
                if ((length1 + length2) % 2 == 1) {
                    return (double) Math.max(left1, left2);
                } else {
                    double left = Math.max(left1, left2);
                    double right = Math.min(right1, right2);

                    return (left + right) / 2;
                }
            }

            if (left1 > right2) {
                end = partition1 - 1;
            } else {
                start = partition1 + 1;
            }
        }

        return -1;
    }
}