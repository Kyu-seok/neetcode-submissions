class Solution {
    public String minRemoveToMakeValid(String s) {

        StringBuilder firstPass = new StringBuilder();

        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
                firstPass.append(c);
            } else if (c == ')') {
                if (balance > 0) {
                    balance--;
                    firstPass.append(c);
                }
            } else {
                firstPass.append(c);
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = firstPass.length() - 1; i >= 0; i--) {
            char c = firstPass.charAt(i);

            if (c == '(' && balance > 0) {
                balance--;
            } else {
                result.append(c);
            }
        }

        return result.reverse().toString();
    }
}