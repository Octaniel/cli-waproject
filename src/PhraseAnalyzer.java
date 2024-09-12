import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhraseAnalyzer {
    private Map<String, Object> hierarchy;

    public PhraseAnalyzer(Map<String, Object> hierarchy) {
        this.hierarchy = hierarchy;
    }

    public Map<String, Integer> analyzePhrase(String phrase, int depth) {
        Map<String, Integer> result = new HashMap<>();
        String[] words = phrase.split("\\s+");

        for (String word : words) {
            searchAtDepth(hierarchy, word, depth, 1, result, null);
        }

        return result;
    }

    private void searchAtDepth(Map<String, Object> currentLevel, String word, int targetDepth, int currentDepth, Map<String, Integer> result, String keyP) {
        if (currentDepth >= targetDepth) {
            for (String key : currentLevel.keySet()) {
                Object value = currentLevel.get(key);

                if (value instanceof List) {
                    List<String> items = (List<String>) value;
                    if (items.stream().map(String::toLowerCase).toList().contains(word.toLowerCase())) {
                        if (keyP == null)
                            result.put(key, result.getOrDefault(key, 0) + 1);
                        else
                            result.put(keyP, result.getOrDefault(keyP, 0) + 1);
                    }
                } else {
                    String keyS = keyP;
                    if (currentDepth == targetDepth){
                        keyS = key;
                    }
                    Object subCategory = currentLevel.get(key);
                    if (subCategory instanceof Map) {
                        searchAtDepth((Map<String, Object>) subCategory, word, targetDepth, currentDepth + 1, result, keyS);
                    }
                }
            }
        } else {
            for (Object subCategory : currentLevel.values()) {
                if (subCategory instanceof Map) {
                    searchAtDepth((Map<String, Object>) subCategory, word, targetDepth, currentDepth + 1, result, null);
                }
            }
        }
    }
}
