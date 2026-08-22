class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];

        return dfs(s, set, memo, 0);
    }

    private boolean dfs(String s, Set<String> set, Boolean[] memo, int i) {
        if (i == s.length()) return true;

        if (memo[i] != null) return memo[i];

        for (int j = i + 1; j <= s.length(); j++) {
            if (set.contains(s.substring(i, j))) {
                if (dfs(s, set, memo, j)) {
                    return true;
                }
            }
        }

        return memo[i] = false;
    }
}
