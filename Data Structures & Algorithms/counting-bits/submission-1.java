class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = getNumOfOneBit(i);
        }

        return arr;
    }

    private int getNumOfOneBit(int num) {
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                count++;
            }

            num >>>= 1;
        }

        return count;
    }
}
