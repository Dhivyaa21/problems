import java.util.*;

public class KFrequentWords {
    public static List<String> solve(int k, String[] keyWords, String[] reviews) {
        Map<String, Integer> keyWordCount = new HashMap<>();
        for (String keyWord: keyWords) {
            keyWordCount.put(keyWord, 0);
        }
        for (String review: reviews) {
            for (String word: review.split("\\s")) {
                if (keyWordCount.containsKey(word)) keyWordCount.put(word, keyWordCount.get(word) + 1);
            }
        }

        List<String> words = new ArrayList<>(keyWordCount.keySet());
        Collections.sort(words, (w1, w2) -> (keyWordCount.get(w2) - keyWordCount.get(w1) == 0) ?
                w1.compareTo(w2) : keyWordCount.get(w2) - keyWordCount.get(w1));
        return words.subList(0, k);
    }

    public static void main(String[] args) {
        int k1 = 2;
        String[] keywords1 = { "anacell", "cetracular", "betacellular" };
        String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell", };
        int k2 = 2;
        String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services", "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
        System.out.println(solve(k1, keywords1, reviews1));
        System.out.println(solve(k2, keywords2, reviews2));
    }
}
