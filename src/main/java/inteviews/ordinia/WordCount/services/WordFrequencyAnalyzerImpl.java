package inteviews.ordinia.WordCount.services;


import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {

    private static final String SEPERATOR_CHARACTERS = " ;:-,";

    @Override
    public int calculateHighestFrequency(String text) throws InvalidInputException {

        if (null == text || text.isEmpty()) {
            throw new InvalidInputException("There must be at least one word in the text");
        }
        //Clean the text
        text = text.toLowerCase().trim();

        //Split up with multiple separators
        List<String> AllWords = Arrays.asList(StringUtils.split(text, SEPERATOR_CHARACTERS));

        //Count the words
        Map<String, Long> wordCounts =
                AllWords.stream()
                        .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        //Get the highest value
        return Collections.max(wordCounts.values()).intValue();
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) throws InvalidInputException {
        if (null == text || text.isEmpty()) {
            throw new InvalidInputException("There must be at least one word in the text");
        }

        if (null == word || word.isEmpty()) {
            throw new InvalidInputException("You must at least select one word to check");
        }

        if (!text.contains(word)) {
            return 0;
        }

        //Clean the text
        text = text.toLowerCase().trim();

        //Split up with multiple separators
        List<String> AllWords = Arrays.asList(StringUtils.split(text, SEPERATOR_CHARACTERS));

        long returnValue = AllWords.stream()
                .filter(countWord -> countWord.equals(word))
                .count();

        return (int) returnValue;
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) throws InvalidInputException {
        if (null == text || text.isEmpty()) {
            throw new InvalidInputException("There must be at least one word in the text");
        }

        if (n <= 0) {
            throw new InvalidInputException("You must have a positive value to check the most frequent words");
        }

        //Clean the text
        text = text.toLowerCase().trim();

        //Split up with multiple separators
        List<String> AllWords = Arrays.asList(StringUtils.split(text, SEPERATOR_CHARACTERS));

        //Count the words
        Map<String, Long> wordCounts =
                AllWords.stream()
                        .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        ArrayList<WordFrequency> wordFrequencies = new ArrayList<>();

        wordCounts.forEach(wordCount -> {
                    WordFrequencyImpl freugencyWord =
                            new WordFrequencyImpl(wordCount.));
                }

                var test = wordCounts.entrySet()
                        .stream()
                        .sorted(Comparator.comparingInt(e -> e.getValue().intValue()))
                        //.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


        return null;
    }
}
