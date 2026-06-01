class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int maxLen = 1;
        int currLen = 1;

        for (int i = 1; i < arr.length; i++) {
            int cmp = Integer.compare(arr[i], arr[i - 1]);

            if (cmp == 0) {
                currLen = 1;
            } else if (i == 1 || (Integer.compare(arr[i - 1], arr[i - 2]) * cmp) > 0) { 
                currLen = 2;
            } else {
                currLen++;
            }

            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}