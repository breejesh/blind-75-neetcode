class Trie {

    private static class TrieNode {
        Character val;
        Map<Character, TrieNode> children;
        Integer terminationCount;

        public TrieNode() {
            children = new HashMap<>();
            terminationCount = 0;
            val = null;
        }

        public TrieNode(Character character) {
            children = new HashMap<>();
            terminationCount = 0;
            val = character;
        }
    }

    TrieNode head;
    Integer maxWordLength;

    public Trie() {
        head = new TrieNode();
        maxWordLength = 0;
    }

    public void insert(String str) {
        if (str == null || str.equals("")) {
            return;
        } else {
            int strLen = str.length();
            if(strLen > maxWordLength) {
                maxWordLength = strLen;
            }
            TrieNode iter = head;
            for (int i = 0; i < strLen; i++) {
                if (!iter.children.containsKey(str.charAt(i))) {
                    TrieNode node = new TrieNode(str.charAt(i));
                    iter.children.put(str.charAt(i), node);
                    iter = node;
                } else {
                    iter = iter.children.get(str.charAt(i));
                }
            }
            iter.terminationCount++;
        }
    }

    public boolean search(String word) {
        return searchWrapper(word, false);
    }

    public boolean startsWith(String prefix) {
        return searchWrapper(prefix, true);
    }

    private boolean searchWrapper(String str, boolean isPrefixMatch) {
        if (str == null || str.equals("")) {
            return false;
        } else {
            int strLen = str.length();
             if (strLen > maxWordLength) {
                return false;
            }
            TrieNode iter = head;
            for (int i = 0; i < strLen; i++) {
                if (!iter.children.containsKey(str.charAt(i))) {
                    return false;
                } else {
                    iter = iter.children.get(str.charAt(i));
                }
            }
            if (iter.terminationCount == 0 && !isPrefixMatch) {
                return false;
            } else {
                return true;
            }
        }
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
