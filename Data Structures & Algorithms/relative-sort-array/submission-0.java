class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];

        for (int num : arr1) {
            freq[num]++;
        }

        int idx = 0;

        for (int i = 0; i < arr2.length; i++) {
            int num = arr2[i];
            while (freq[num] > 0) {
                arr1[idx++] = num;
                freq[num]--;
            }
        }

        for (int i = 0; i <= 1000; i++) {
            while (freq[i] > 0) {
                arr1[idx++] = i;
                freq[i]--;
            }
        }

        return arr1;
    }
}