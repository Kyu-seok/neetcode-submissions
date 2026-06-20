class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        Queue<Integer> positives = new ArrayDeque<>();
        Queue<Integer> negatives = new ArrayDeque<>();

        for (int num : nums) {
            if (num > 0) {
                positives.add(num);
            } else {
                negatives.add(num);
            }
        }

        int i = 0;

        while (i < n) {
            result[i++] = positives.remove();
            result[i++] = negatives.remove();
        }

        return result;
    }
}