class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] rank = new int[26];

        for (int i = 0; i < 26; i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        for (int i = 1; i < words.length; i++) {
            if (!isSmaller(words[i - 1], words[i], rank)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSmaller(String word1, String word2, int[] rank) {
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            int rank1 = rank[word1.charAt(i) - 'a'];
            int rank2 = rank[word2.charAt(i) - 'a'];

            if (rank1 < rank2) {
                return true;
            } else if (rank1 > rank2) {
                return false;
            } 
        }

        return (word1.length() <= word2.length()) ? true : false;
    }
}