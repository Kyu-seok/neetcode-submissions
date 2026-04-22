class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backtrack(result, sb, n, n);

        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, int openCount, int closeCount) {
        if (openCount == 0 && closeCount == 0) {
            result.add(sb.toString());
            return;
        }

        if (openCount > 0) {
            sb.append("(");
            backtrack(result, sb, openCount - 1, closeCount);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (closeCount > openCount) {
            sb.append(")");
            backtrack(result, sb, openCount, closeCount - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
