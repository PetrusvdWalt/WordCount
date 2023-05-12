package inteviews.ordinia.WordCount.services;

import java.util.List;

public interface WordFrequencyAnalyzer {

    /**
     * Calculates the highest frequency of a word from a given text.
     * @param text The text to find the frequency in. Can be any case, and deliminated in with these values: " ;:-".
     * @return An integer value with the highest frequency of the word.
     * @throws InvalidInputException If the text is empty or if it is null.
     */
    int calculateHighestFrequency(String text) throws InvalidInputException;

    /**
     * From the text, it counts the amount of the words in the text in the text
     * @param text The text to find the frequency in. Can be any case, and deliminated in with these values: " ;:-"
     * @param word The word to find the frequency for.
     * @return the frequency of the given word in the given string.
     * @throws InvalidInputException  If either the word or the text is empty or if it is null.
     */
    int calculateFrequencyForWord (String text, String word) throws InvalidInputException;


    List<WordFrequencyImpl> calculateMostFrequentNWords (String text, int n) throws InvalidInputException;
}
