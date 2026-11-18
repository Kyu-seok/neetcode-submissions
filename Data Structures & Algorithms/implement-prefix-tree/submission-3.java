
class PrefixTree {

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = findNode(word);
        return node != null && node.isWord;
    }

    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    private TrieNode findNode(String str) {
        TrieNode node = root;

        for (char c : str.toCharArray()) {
            node = node.children[c - 'a'];

            if (node == null) {
                return null;
            }
        }

        return node;
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
}
