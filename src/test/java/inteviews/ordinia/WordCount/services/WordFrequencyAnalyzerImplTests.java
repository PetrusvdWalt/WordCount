package inteviews.ordinia.WordCount.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class WordFrequencyAnalyzerImplTests {

    private final WordFrequencyAnalyzerImpl wordFrequencyAnalyzerImpl = new WordFrequencyAnalyzerImpl();

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
    void testInvalidInputNullString() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            wordFrequencyAnalyzerImpl.calculateHighestFrequency(null);
        });

        assertEquals("There must be at least one word in the text", exception.getMessage());
    }

    @Test
    void testInvalidInputEmptyString() {
        Exception exception = assertThrows(InvalidInputException.class, () -> {
            wordFrequencyAnalyzerImpl.calculateHighestFrequency("");
        });

        assertEquals("There must be at least one word in the text", exception.getMessage());
    }
}
