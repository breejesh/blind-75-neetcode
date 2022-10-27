// TODO solve again with Tries
class WordDictionary {

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

    public WordDictionary() {
        head = new TrieNode();
        maxWordLength = 0;
    }

    public void addWord(String word) {
        if (word == null || word.equals("")) {
            return;
        } else {
            int strLen = word.length();
            if (strLen > maxWordLength) {
                maxWordLength = strLen;
            }
            TrieNode iter = head;
            for (int i = 0; i < strLen; i++) {
                if (!iter.children.containsKey(word.charAt(i))) {
                    TrieNode node = new TrieNode(word.charAt(i));
                    iter.children.put(word.charAt(i), node);
                    iter = node;
                } else {
                    iter = iter.children.get(word.charAt(i));
                }
            }
            iter.terminationCount++;
        }
    }

    public boolean search(String query) {
        if (query == null || query.equals("")) {
            return false;
        } else {
            int strLen = query.length();
            if (strLen > maxWordLength) {
                return false;
            }
            List<TrieNode> trieList = new ArrayList<>();
            trieList.add(head);
            for (int i = 0; i < strLen; i++) {
                if (query.charAt(i) == '.') {
                    List<TrieNode> newTrieList = new ArrayList<>();
                    for (TrieNode trieNode : trieList) {
                        newTrieList.addAll(trieNode.children.values());
                    }
                    trieList = newTrieList;
                } else {
                    List<TrieNode> newTrieList = new ArrayList<>();
                    for (TrieNode trieNode : trieList) {
                        if (trieNode.children.containsKey(query.charAt(i))) {
                            newTrieList.add(trieNode.children.get(query.charAt(i)));
                        }
                    }
                    if (newTrieList.isEmpty()) {
                        return false;
                    } else {
                        trieList = newTrieList;
                    }
                }
            }
            for (TrieNode trieNode : trieList) {
                if (trieNode.terminationCount != 0) {
                    return true;
                }
            }
            return false;
        }
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
