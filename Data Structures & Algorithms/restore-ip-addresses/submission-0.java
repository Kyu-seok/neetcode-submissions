class Solution {

    List<String> result = new ArrayList<>();
    List<String> parts = new ArrayList<>();
    String s;

    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        dfs(0);
        return result;
    }

    private void dfs(int i) {

        if (parts.size() == 4) {
            if (i == s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }

        int remainingDigits = s.length() - i;
        int remainingParts = 4 - parts.size();

        if (remainingDigits < remainingParts || remainingDigits > remainingParts * 3) {
            return;
        }

        for (int len = 1; len <= 3 && i + len <= s.length(); len++) {
            String part = s.substring(i, i + len);

            if (!isValid(part)) continue;

            parts.add(part);
            dfs(i + len);
            parts.remove(parts.size() - 1);
        }
    }

    private boolean isValid(String part) {
        if (part.length() > 1 && part.charAt(0) == '0') return false;

        return Integer.parseInt(part) <= 255;
    }
}