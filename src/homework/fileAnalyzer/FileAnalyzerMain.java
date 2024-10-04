package homework.fileAnalyzer;

import java.io.IOException;

public class FileAnalyzerMain {

    public static final String FILE_PATH = "C:\\Users\\hovoe\\IdeaProjects\\JavaCore 24-25\\src\\homework\\fileAnalyzer\\file.txt";

    public static void main(String[] args) throws IOException {
        FileAnalyzer fileAnalyzer = new FileAnalyzer();
        System.out.println(fileAnalyzer.wordMap(FILE_PATH));
        System.out.println("Total count of words is " + fileAnalyzer.totalWordCount(FILE_PATH));
        System.out.println("Unique count of words is " + fileAnalyzer.uniqueWordCount(FILE_PATH));
        System.out.println("Top N words " + fileAnalyzer.topFrequentWords(FILE_PATH, 3));
        System.out.println("Count of word  " + fileAnalyzer.countWordOccurrences(FILE_PATH, "suscipit"));
    }
}
