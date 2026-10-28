class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int gap = nums1.length - m;

        for (int i = m - 1; i >= 0; i--) {
            nums1[i + gap] = nums1[i];
        }

        for (int i = 0; i < gap; i++) {
            nums1[i] = 0;
        }

        int p1 = gap;
        int p2 = 0;
        int i = 0;

        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                nums1[i++] = nums1[p1++];
            } else {
                nums1[i++] = nums2[p2++];
            }
        }

        while (i < nums1.length && p1 < nums1.length) {
            nums1[i++] = nums1[p1++];
        }

        while (i < nums1.length && p2 < nums2.length) {
            nums1[i++] = nums2[p2++];
        }
        
    }
}