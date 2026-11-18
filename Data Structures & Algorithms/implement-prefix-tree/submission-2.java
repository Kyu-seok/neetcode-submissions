class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        insert(word, root, 0);
    }

    private void insert(String word, TrieNode node, int i) {
        if (i == word.length()) {
            node.isWord = true;
            return;
        }

        char c = word.charAt(i);

        if (node.children[c - 'a'] == null) {
            node.children[c - 'a'] = new TrieNode();
        }

        TrieNode child = node.children[c - 'a'];


        insert(word, child, i + 1);
    }

    public boolean search(String word) {
        return find(word, root, 0, true);
    }

    public boolean startsWith(String prefix) {
        return find(prefix, root, 0, false);
    }

    private boolean find(String word, TrieNode node, int i, boolean isExactSearch) {
        if (i == word.length()) {
            if (isExactSearch) {
                return node.isWord;
            }
            return true;
        }

        char c = word.charAt(i);
        TrieNode child = node.children[c - 'a'];

        if (child == null) return false;

        return find(word, child, i + 1, isExactSearch);
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children;

    public TrieNode() {
        this.isWord = false;
        this.children = new TrieNode[26];
    }
}