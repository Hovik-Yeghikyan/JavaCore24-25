package homework.fileAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class FileAnalyzer {

    public Map<String, Integer> wordMap(String path) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.replaceAll("\\.", " ")
                        .replaceAll(":", " ")
                        .replaceAll(",", " ")
                        .replaceAll(";", " ")
                        .replaceAll("-", " ")
                        .split(" ");
                for (String word : words) {
                    if (!word.trim().isEmpty()) {
                        if (map.containsKey(word)) {
                            Integer count = map.get(word);
                            map.put(word, ++count);
                        } else {
                            map.put(word, 1);
                        }
                    }
                }
            }
            return map;
        }
    }


    public int totalWordCount(String path) throws IOException {
        Map<String, Integer> map = wordMap(path);
        int totalCount = 0;
        for (Integer value : map.values()) {
            totalCount = totalCount + value;
        }
        return totalCount;
    }

    public int uniqueWordCount(String path) throws IOException {
        Map<String, Integer> map = wordMap(path);
        int uniqueCount = 0;
        for (Integer value : map.values()) {
            if (value == 1) {
                uniqueCount++;
            }
        }
        return uniqueCount;
    }

    public Map<String, Integer> topFrequentWords(String path, int n) throws IOException {
        Map<String, Integer> map = wordMap(path);
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        Map<String, Integer> result = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            Map.Entry<String,Integer> stringIntegerEntry = entries.get(i);
            result.put(stringIntegerEntry.getKey(),stringIntegerEntry.getValue());
        }
        return result;
    }

    public int countWordOccurrences(String path, String word) throws IOException {
        Map<String, Integer> map = wordMap(path);
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if (stringIntegerEntry.getKey().equals(word)) {
                return stringIntegerEntry.getValue();
            }
        }
        return 0;
    }

}
