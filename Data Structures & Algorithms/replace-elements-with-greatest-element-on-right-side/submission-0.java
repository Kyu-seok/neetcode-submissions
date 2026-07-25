class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];

        result[n - 1] = -1;
        if (n == 1) return result;

        int currMax = arr[n - 1];

        int i = n - 2;

        while (i >= 0) {
            result[i] = currMax;
            currMax = Math.max(currMax, arr[i]);
            i--;
        }

        return result;
    }
}