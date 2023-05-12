package inteviews.ordinia.WordCount.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class WordFrequencyAnalyzerImplTests {

    private final WordFrequencyAnalyzerImpl wordFrequencyAnalyzerImpl = new WordFrequencyAnalyzerImpl();


    @Test
    void testBasicCalculateHighestFrequencyIsWorking() {
       int expectedResult = wordFrequencyAnalyzerImpl.calculateHighestFrequency("The sun shines over the lake");




    }
}
