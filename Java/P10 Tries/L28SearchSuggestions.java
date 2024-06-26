import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        children = new TrieNode[26]; // Assuming only lowercase English letters
        isEndOfWord = false;
    }
}

public class L27SearchSuggestions{
    private TrieNode root;

    public SearchSuggestionSystem() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public List<String> searchSuggestions(String query) {
        List<String> suggestions = new ArrayList<>();
        TrieNode current = root;

        // Traverse the trie based on the characters in the query string
        for (char c : query.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return suggestions; // No suggestions found if prefix not present in trie
            }
            current = current.children[index];
        }

        // Recursively find all words with the given prefix
        findAllWordsWithPrefix(current, query, suggestions);
        return suggestions;
    }

    private void findAllWordsWithPrefix(TrieNode node, String prefix, List<String> suggestions) {
        if (node.isEndOfWord) {
            suggestions.add(prefix); // Add the prefix itself if it represents a complete word
        }

        // Recursively traverse all children of the current node
        for (int i = 0; i < 26; i++) {
            TrieNode child = node.children[i];
            if (child != null) {
                findAllWordsWithPrefix(child, prefix + (char) ('a' + i), suggestions);
            }
        }
    }

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String[] queries = {"m", "mon", "t", "mouse"};

        SearchSuggestionSystem system = new SearchSuggestionSystem();
        for (String product : products) {
            system.insert(product);
        }

        for (String query : queries) {
            List<String> suggestions = system.searchSuggestions(query);
            System.out.println("For \"" + query + "\": " + suggestions);
        }
    }
}
