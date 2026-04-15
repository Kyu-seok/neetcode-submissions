class WordDictionary {

    TrieNode root;

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        addWord(root, word, 0);
    }

    private void addWord(TrieNode root, String word, int i) {
        if (i == word.length()) {
            root.isWord = true;
            return;
        }

        char c = word.charAt(i);

        if (root.children[c - 'a'] == null) {
            root.children[c - 'a'] = new TrieNode();
        }

        addWord(root.children[c - 'a'], word, i + 1);
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(TrieNode node, String word, int i) {
        if (node == null) return false;
        if (i == word.length()) return node.isWord ? true : false;

        char c = word.charAt(i);

        if (c != '.') {
            return search(node.children[c - 'a'], word, i + 1);
        } else {
            for (int j = 0; j < 26; j++) {
                if (search(node.children[j], word, i + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
