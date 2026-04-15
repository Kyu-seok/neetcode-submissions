class PrefixTree {

    TrieNode root;

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        insert(root, word, 0);
    }

    private void insert(TrieNode node, String word, int i) {
        if (i == word.length()) {
            node.isWord = true;
            return;
        }

        char c = word.charAt(i);
        if (node.children[c - 'a'] == null) {
            node.children[c - 'a'] = new TrieNode();
        }

        insert(node.children[c - 'a'], word, i + 1);
    }

    public boolean search(String word) {
        return searchWith(root, word, 0, true);
    }

    private boolean searchWith(TrieNode root, String word, int i, boolean findWord) {
        if (root == null) return false;
        if (i == word.length()) {
            return findWord ? root.isWord : true;
        }

        char c = word.charAt(i);

        return searchWith(root.children[c - 'a'], word, i + 1, findWord);
    }

    public boolean startsWith(String prefix) {
        return searchWith(root, prefix, 0, false);
    }
}
