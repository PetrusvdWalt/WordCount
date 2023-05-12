package inteviews.ordinia.WordCount.services;

import inteviews.ordinia.WordCount.exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class WordFrequencyAnalyzerImplTests {

    public static final String THE_SUN_SHINES_OVER_THE_LAKE_LIKE_WITH_SUN = "The sun shines over the lake like with sun";
    public static final String THE_SUN_SHINES_OVER_THE_LAKE = "The sun shines over the lake";
    public static final String THE_SUN_SHINES_OVER_THE_LAKE_IN_THE_MORNING_IT_LOOKS_GREAT_THE_SUN_OVER_THE_LAKE_OVER = "The sun shines over the lake in the morning. It looks great, the sun, over the lake, over";
    private final WordFrequencyAnalyzerImpl wordFrequencyAnalyzerImpl = new WordFrequencyAnalyzerImpl();

    // region CalculateHighestFrequency Tests

    @Test
    void testBasicCalculateHighestFrequencyIsWorking() throws InvalidInputException {
        int expectedResult = wordFrequencyAnalyzerImpl.calculateHighestFrequency(THE_SUN_SHINES_OVER_THE_LAKE);

        assertEquals(2, expectedResult);
    }

    @Test
    void testBasicCalculateHighestFrequencyIsWorkingWithMultipleMax() throws InvalidInputException {
        int expectedResult = wordFrequencyAnalyzerImpl.calculateHighestFrequency(THE_SUN_SHINES_OVER_THE_LAKE_LIKE_WITH_SUN);

        assertEquals(2, expectedResult);
    }

    @Test
    void testInvalidInputNullStringForCalculateHighestFrequency() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            wordFrequencyAnalyzerImpl.calculateHighestFrequency(null);
        });

        assertEquals("There must be at least one word in the text", exception.getMessage());
    }

    @Test
    void testInvalidInputEmptyStringForCalculateHighestFrequency() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            wordFrequencyAnalyzerImpl.calculateHighestFrequency("");
        });

        assertEquals("There must be at least one word in the text", exception.getMessage());
    }

    // endregion CalculateHighestFrequency Tests

    // region CalculateFrequencyForWord Tests

    @Test
    void testSuccessCalculateFrequencyForWord() throws InvalidInputException {
        int expectedResult = wordFrequencyAnalyzerImpl.calculateFrequencyForWord(THE_SUN_SHINES_OVER_THE_LAKE, "the");

        assertEquals(2, expectedResult);
    }

    @Test
    void testSuccessCalculateFrequencyForWordWithMultipleItems() throws InvalidInputException {
        int expectedResult = wordFrequencyAnalyzerImpl.calculateFrequencyForWord(THE_SUN_SHINES_OVER_THE_LAKE_LIKE_WITH_SUN, "the");

        assertEquals(2, expectedResult);
    }

    @Test
    void testInvalidInputNullStringForCalculateFrequencyForText() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            wordFrequencyAnalyzerImpl.calculateFrequencyForWord(null, "the");
        });

        assertEquals("There must be at least one word in the text", exception.getMessage());
    }

    @Test
    void testInvalidInputEmptyStringCalculateFrequencyForText() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            wordFrequencyAnalyzerImpl.calculateFrequencyForWord("", "the");
        });

        assertEquals("There must be at least one word in the text", exception.getMessage());
    }

    @Test
    void testInvalidInputNullStringForCalculateFrequencyForWord() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            wordFrequencyAnalyzerImpl.calculateFrequencyForWord(THE_SUN_SHINES_OVER_THE_LAKE, null);
        });

        assertEquals("You must at least select one word to check", exception.getMessage());
    }

    @Test
    void testInvalidInputEmptyStringCalculateFrequencyForWord() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            wordFrequencyAnalyzerImpl.calculateFrequencyForWord(THE_SUN_SHINES_OVER_THE_LAKE, "");
        });

        assertEquals("You must at least select one word to check", exception.getMessage());
    }

    @Test
    void testWordNotInTextForCalculateFrequencyForWord() throws InvalidInputException {
        int expectedResult = wordFrequencyAnalyzerImpl.calculateFrequencyForWord(THE_SUN_SHINES_OVER_THE_LAKE, "are");

        assertEquals(0, expectedResult);
    }

    // endregion CalculateFrequencyForWord Tests

    // region CalculateMostFrequentNWords Tests “The sun shines over the lake”

    @Test
    void testBasicCalculateMostFrequentNWordsIsWorking() throws InvalidInputException {
        int expectedN = 3;

        List<WordFrequency> expectedResult = wordFrequencyAnalyzerImpl.calculateMostFrequentNWords(
                THE_SUN_SHINES_OVER_THE_LAKE_IN_THE_MORNING_IT_LOOKS_GREAT_THE_SUN_OVER_THE_LAKE_OVER, expectedN);

        assertEquals(expectedN, expectedResult.size());
        assertEquals(5, expectedResult.stream().findFirst().get().getFrequency());
    }

    @Test
    void testCalculateMostFrequentNWordsIsWorkingWithWordOrder() throws InvalidInputException {
        int expectedN = 3;

        List<WordFrequency> expectedResult = wordFrequencyAnalyzerImpl.calculateMostFrequentNWords(
                THE_SUN_SHINES_OVER_THE_LAKE, expectedN);

        assertEquals(expectedN, expectedResult.size());
        assertEquals("the", expectedResult.get(0).getWord());
        assertEquals(2, expectedResult.get(0).getFrequency());

        assertEquals("lake", expectedResult.get(1).getWord());
        assertEquals(1, expectedResult.get(1).getFrequency());

        assertEquals("over", expectedResult.get(2).getWord());
        assertEquals(1, expectedResult.get(2).getFrequency());
    }

    @Test
    void testInvalidCalculateMostFrequentNWithNLargerThanWords() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            wordFrequencyAnalyzerImpl.calculateMostFrequentNWords(THE_SUN_SHINES_OVER_THE_LAKE, 15);
        });

        assertEquals("You must select an N with more values than the collected word counts", exception.getMessage());
    }

    @Test
    void testInvalidBasicCalculateMostFrequentNWordsForTextNull() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            wordFrequencyAnalyzerImpl.calculateMostFrequentNWords(null, 1);
        });

        assertEquals("There must be at least one word in the text", exception.getMessage());
    }

    @Test
    void testInvalidBasicCalculateMostFrequentNWordsForTextEmpty() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            wordFrequencyAnalyzerImpl.calculateMostFrequentNWords("", 1);
        });

        assertEquals("There must be at least one word in the text", exception.getMessage());
    }

    @Test
    void testInvalidBasicCalculateMostFrequentNWordsForNBelowOne() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            wordFrequencyAnalyzerImpl.calculateMostFrequentNWords(THE_SUN_SHINES_OVER_THE_LAKE_IN_THE_MORNING_IT_LOOKS_GREAT_THE_SUN_OVER_THE_LAKE_OVER, 0);
        });

        assertEquals("You must have a positive value to check the most frequent words", exception.getMessage());
    }

    // endregion CalculateMostFrequentNWords Tests
}
