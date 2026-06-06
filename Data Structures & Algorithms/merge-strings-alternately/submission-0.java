class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int minLen = Math.min(m, n);

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < minLen) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }

        while (i < m) {
            sb.append(word1.charAt(i));
            i++;
        }

        while (i < n) {
            sb.append(word2.charAt(i));
            i++;
        }

        return sb.toString();
    }
}