class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')  {
                stack.offerLast(c);
            } else {
                Character open = stack.pollLast();
                if (open == null) return false;
                if (c == ')') {
                    if (open != '(') return false;
                } else if (c == '}') {
                    if (open != '{') return false;
                } else if (c == ']') {
                    if (open != '[') return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
