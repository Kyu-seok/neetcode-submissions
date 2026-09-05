class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        insert(root, word, 0);
    }

    private void insert(TrieNode root, String word, int i) {
        if (i >= word.length()) {
            root.isWord = true;
            return;
        }

        char c = word.charAt(i);

        TrieNode child = root.children[c - 'a'];

        if (child == null) {
            root.children[c - 'a'] = new TrieNode();
            child = root.children[c - 'a'];
        }

        insert(child, word, i + 1);
    }

    public boolean search(String word) {
        return search(root, word, 0, true);
    }

    private boolean search(TrieNode root, String word, int i, boolean isWordSearch) {
        if (i >= word.length() || root == null) return false;

        char c = word.charAt(i);

        if (i == word.length() - 1 && root.children[c - 'a'] != null) {
            return (!isWordSearch) ? true : root.children[c- 'a'].isWord;
        }

        return search(root.children[c - 'a'], word, i + 1, isWordSearch);
    }

    public boolean startsWith(String prefix) {
        return search(root, prefix, 0, false);
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
}
