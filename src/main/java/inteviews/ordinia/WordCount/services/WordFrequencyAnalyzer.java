package inteviews.ordinia.WordCount.services;

import java.util.List;

public interface WordFrequencyAnalyzer {
    int calculateHighestFrequency(String text) throws InvalidInputException;
    int calculateFrequencyForWord (String text, String word) throws InvalidInputException;
    List<WordFrequency> calculateMostFrequentNWords (String text, int n);
}
