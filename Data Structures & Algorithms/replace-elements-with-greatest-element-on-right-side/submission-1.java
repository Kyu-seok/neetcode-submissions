class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;

        int currMax = arr[n - 1];
        arr[n - 1] = -1;

        if (n == 1) return arr;


        int i = n - 2;

        while (i >= 0) {
            int temp = arr[i];
            arr[i] = currMax;
            currMax = Math.max(currMax, temp);
            i--;
        }

        return arr;
    }
}