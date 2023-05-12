package inteviews.ordinia.WordCount.services;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {

    private static final String SEPERATOR_CHARACTERS = " ;:-";

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
        Map<String, Long> counts =
                AllWords.stream()
                        .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        //Get the highest value
        return Collections.max(counts.values()).intValue();
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        return 0;
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        return null;
    }
}
