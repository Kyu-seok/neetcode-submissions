class Solution {

    List<String> result = new ArrayList<>();
    List<String> parts = new ArrayList<>();
    String s;

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        dfs(0);
        return result;
    }

    private void dfs(int index) {
        if (parts.size() == 4) {
            if (index == s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }

        int leftDigits = s.length() - index;
        int leftParts = 4 - parts.size();

        if (leftDigits < leftParts || leftDigits > leftParts * 3) return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);
            if (!isValid(part)) continue;
            parts.add(part);
            dfs(index + len);
            parts.remove(parts.size() - 1);
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1) {
            if (s.charAt(0) == '0') return false;
        }

        return Integer.parseInt(s) <= 255;
    }
}