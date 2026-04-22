class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backtrack(result, sb, n, 0, 0);

        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, int n, int openCount, int closeCount) {
        if (openCount == n && closeCount == n) {
            result.add(sb.toString());
            return;
        }

        if (openCount < n) {
            sb.append("(");
            backtrack(result, sb, n, openCount + 1, closeCount);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeCount < openCount) {
            sb.append(")");
            backtrack(result, sb, n, openCount, closeCount + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
