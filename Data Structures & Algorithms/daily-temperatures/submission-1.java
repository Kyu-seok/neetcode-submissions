class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peekFirst()] < temperatures[i]) {
                int prevIndex = stack.pollFirst();

                result[prevIndex] = i - prevIndex;
            }

            stack.offerFirst(i);
        }

        return result;
    }
}
