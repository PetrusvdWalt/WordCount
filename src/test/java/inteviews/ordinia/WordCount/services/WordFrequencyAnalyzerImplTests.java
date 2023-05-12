package inteviews.ordinia.WordCount.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class WordFrequencyAnalyzerImplTests {

    private final WordFrequencyAnalyzerImpl wordFrequencyAnalyzerImpl = new WordFrequencyAnalyzerImpl();

    // region CalculateHighestFrequency Tests

    @Test
    void testBasicCalculateHighestFrequencyIsWorking() throws InvalidInputException {
        int expectedResult = wordFrequencyAnalyzerImpl.calculateHighestFrequency("The sun shines over the lake");

        assertEquals(2, expectedResult);
    }

    @Test
    void testBasicCalculateHighestFrequencyIsWorkingWithMultipleMax() throws InvalidInputException {
        int expectedResult = wordFrequencyAnalyzerImpl.calculateHighestFrequency("The sun shines over the lake like with sun");

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

    //region CalculateFrequencyForWord Tests

    @Test
    void testSuccessCalculateFrequencyForWord() throws InvalidInputException {
        int expectedResult = wordFrequencyAnalyzerImpl.calculateFrequencyForWord("The sun shines over the lake", "the");

        assertEquals(2, expectedResult);
    }


    @Test
    void testSuccessCalculateFrequencyForWordWithMultipleItems() throws InvalidInputException {
        int expectedResult = wordFrequencyAnalyzerImpl.calculateFrequencyForWord("The sun shines over the lake like with sun", "the");

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
            wordFrequencyAnalyzerImpl.calculateFrequencyForWord("The sun shines over the lake", null);
        });

        assertEquals("You must at least select one word to check", exception.getMessage());
    }

    @Test
    void testInvalidInputEmptyStringCalculateFrequencyForWord() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            wordFrequencyAnalyzerImpl.calculateFrequencyForWord("The sun shines over the lake", "");
        });

        assertEquals("You must at least select one word to check", exception.getMessage());
    }

    @Test
    void testWordNotInTextForCalculateFrequencyForWord() throws InvalidInputException {
        int expectedResult = wordFrequencyAnalyzerImpl.calculateFrequencyForWord("The sun shines over the lake", "are");

        assertEquals(0, expectedResult);
    }


    //endregion CalculateFrequencyForWord Tests
}
