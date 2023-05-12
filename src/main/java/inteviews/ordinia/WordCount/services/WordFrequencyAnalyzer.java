package inteviews.ordinia.WordCount.services;

import java.util.List;

public interface WordFrequencyAnalyzer {

    /**
     * Calculates the highest frequency of a word from a given text.
     *
     * @param text The text to find the frequency in. Can be any case, and deliminated in with these values: " ;:-".
     * @return An integer value with the highest frequency of the word.
     * @throws InvalidInputException If the text is empty or if it is null.
     */
    int calculateHighestFrequency(String text) throws InvalidInputException;

    /**
     * From the text, it counts the amount of the words in the text in the text
     *
     * @param text The text to find the frequency in. Can be any case, and deliminated in with these values: " ;:-"
     * @param word The word to find the frequency for.
     * @return the frequency of the given word in the given string.
     * @throws InvalidInputException If either the word or the text is empty or if it is null.
     */
    int calculateFrequencyForWord(String text, String word) throws InvalidInputException;

    /**
     * This function takes the input and calculates the first N most frequent words. It will also sort the result in reverse alphabetical order
     * so that if there is frequencies with the same counts in the result set, it will be reversed by the word.
     *
     * @param text Incoming text to check for the frequencies
     * @param n    How many results to return
     * @return A lost with WordFrequncy object with the first N most frequent words in the text
     * @throws InvalidInputException If either the text is empty, or the n is less than 0, or if n is larger than the sorted word set.
     */
    List<WordFrequency> calculateMostFrequentNWords(String text, int n) throws InvalidInputException;
}
