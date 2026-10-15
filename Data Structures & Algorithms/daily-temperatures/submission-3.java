class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int curr = temperatures[i];

            while (!stack.isEmpty() && stack.peek()[0] < curr) {
                int[] prev = stack.pop();
                int prevIndex = prev[1];
                result[prevIndex] = i - prevIndex;
            }

            stack.push(new int[] {curr, i});
        }

        return result;
    }
}
