class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String str : operations) {
            if ("+".equals(str)) {
                int a = stack.pollLast();
                int b = stack.peekLast();
                stack.offerLast(a);
                stack.offerLast(a + b);
            } else if ("D".equals(str)) {
                stack.offerLast(stack.peekLast() * 2);
            } else if ("C".equals(str)) {
                stack.pollLast();
            } else {
                stack.offerLast(Integer.parseInt(str));
            }
        }

        int result = 0;

        for (int score : stack) {
            result += score;
        }

        return result;
    }
}