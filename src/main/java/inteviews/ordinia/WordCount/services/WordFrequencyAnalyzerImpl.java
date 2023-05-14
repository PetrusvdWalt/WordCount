package inteviews.ordinia.WordCount.services;


import inteviews.ordinia.WordCount.exceptions.InvalidInputException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {

    private static final String SEPERATOR_CHARACTERS = " ;:-,[].()\"'“?";

    @Override
    public int calculateHighestFrequency(String text) throws InvalidInputException {

        if (null == text || text.isEmpty()) {
            throw new InvalidInputException("There must be at least one word in the text");
        }
        //Clean the text
        text = text.toLowerCase().replaceAll("[0-9]", "").trim();

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

        //Clean the text
        text = text.toLowerCase().replaceAll("[0-9]", "").trim();
        word = word.toLowerCase().trim();

        if (!text.contains(word)) {
            return 0;
        }

        //Split up with multiple separators
        List<String> AllWords = Arrays.asList(StringUtils.split(text, SEPERATOR_CHARACTERS));

        String finalWord = word;

        long returnValue = AllWords.stream()
                .filter(countWord -> countWord.equals(finalWord))
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
        text = text.toLowerCase().replaceAll("[0-9]", "").replaceAll("\\r\\n", "").trim();

        //Split up with multiple separators
        List<String> AllWords = Arrays.asList(StringUtils.split(text, SEPERATOR_CHARACTERS));

        //Count the words
        Map<String, Long> wordCounts =
                AllWords.stream()
                        .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        ArrayList<WordFrequency> wordList = new ArrayList<>();

        //Move to a word frequency
        wordCounts.forEach((key, value) -> {
            WordFrequency wordFrequency = new WordFrequencyImpl(key, value.intValue());
            wordList.add(wordFrequency);
        });

        //Sort it
        wordList.sort(Comparator.comparing(WordFrequency::getFrequency)
                .thenComparing(WordFrequency::getWord, Comparator.reverseOrder())
        );

        if (wordList.size() < n) {
            throw new InvalidInputException("You must select an N with more values than the collected word counts");
        }

        Collections.reverse(wordList);

        return wordList.subList(0, n);
    }
}
