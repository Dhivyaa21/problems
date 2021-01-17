import java.util.*;

public class PrefixTrie {
    PrefixTrieNode root = new PrefixTrieNode("");

    public void insertWord(String word) {
        PrefixTrieNode crawl = root;
        int length = word.length();
        StringBuilder sb = new StringBuilder();
        for(int level = 0; level < length; level++) {
            char c = word.charAt(level);
            sb.append(c);
            if (!crawl.children.containsKey(c)) {
                crawl.children.put(c , new PrefixTrieNode(sb.toString()));
            }
            crawl = crawl.children.get(c);
            crawl.addPrefixWord(word);
        }
        crawl.isEndOfWord = true;
    }

    public List<String> searchWords(String prefix) {
        PrefixTrieNode crawl = root;
        int length = prefix.length();
        for (int level = 0; level < length; level++) {
            char c = prefix.charAt(level);
            if (!crawl.children.containsKey(c)) return new ArrayList<>();
            crawl = crawl.children.get(c);
        }
        return crawl.prefixWords;
    }
}

class PrefixTrieNode {
    Map<Character, PrefixTrieNode> children;
    List<String> prefixWords;
    boolean isEndOfWord;
    String prefix;

    PrefixTrieNode(String prefix) {
        this.prefix = prefix;
        children = new HashMap<>();
        isEndOfWord = false;
        prefixWords = new ArrayList<>();
    }

    void addPrefixWord(String prefixWord) {
        if (prefixWords.size() < 3) {
            prefixWords.add(prefixWord);
        }
        Collections.sort(prefixWords, String::compareTo);
    }

    @Override
    public String toString() {
        return "PrefixTrieNode{" +
                "children=" + children +
                ", prefixWords=" + prefixWords +
                '}';
    }
}

class solution {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        PrefixTrie prefixTrie = new PrefixTrie();
        for (String word: products) {
            prefixTrie.insertWord(word);
        }
        List<List<String>> suggestions = new ArrayList<>();

        char[] chars = searchWord.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            suggestions.add(prefixTrie.searchWords(sb.toString()));
        }
        return suggestions;
    }

    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String[] products1 = {"havana"};
        String[] products2 = {"bags","baggage","banner","box","cloths"};

        Collections.sort(Arrays.asList(products1));
        System.out.print(suggestedProducts(products1, "tatiana"));
    }
}
