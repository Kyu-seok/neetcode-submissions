class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int n = temperatures.length;

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peekFirst()[0] < temperatures[i]) {
                int[] arr = stack.pollFirst();
                int prevVal = arr[0];
                int prevIndex = arr[1];

                result[prevIndex] = i - prevIndex;
            }

            stack.offerFirst(new int[] {temperatures[i], i});

        }

        return result;
    }
}
