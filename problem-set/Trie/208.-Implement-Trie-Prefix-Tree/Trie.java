/**
 * @Title: 208. Implement Trie (Prefix Tree)
 * @Author: FFYzz
 * @Mail: cryptochen95 at gmail dot com
 * @Date: 2020/5/14
 */
public class Trie {

    int ALPHABET_SIZE = 26;
    Trie[] children;
    boolean isEndOfWord;


    /**
     * Initialize your data structure here.
     */
    public Trie() {
        isEndOfWord = false;
        children = new Trie[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; ++i) {
            children[i] = null;
        }
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        if (children[word.charAt(0) - 'a'] == null) {
            children[word.charAt(0) - 'a'] = new Trie();
        }
        if (word.length() == 1) {
            children[word.charAt(0) - 'a'].isEndOfWord = true;
        } else {
            children[word.charAt(0) - 'a'].insert(word.substring(1));
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            if (isEndOfWord) {
                return true;
            }
            return false;
        }
        if (children[word.charAt(0) - 'a'] == null) {
            return false;
        } else {
            return children[word.charAt(0) - 'a'].search(word.substring(1));
        }
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return true;
        }
        if (children[prefix.charAt(0) - 'a'] == null) {
            return false;
        } else {
            return children[prefix.charAt(0) - 'a'].startsWith(prefix.substring(1));
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
