class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> numbers = new ArrayDeque<>();

        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int b = numbers.pollLast();
                int a = numbers.pollLast();

                switch (token) {
                    case "+" -> numbers.offerLast(a + b);
                    case "-" -> numbers.offerLast(a - b);
                    case "*" -> numbers.offerLast(a * b);
                    case "/" -> numbers.offerLast(a / b);
                }
            } else {
                numbers.offerLast(Integer.parseInt(token));
            }
        }

        return numbers.pollLast(); 
    }
}
