package inteviews.ordinia.WordCount.controllers;

import inteviews.ordinia.WordCount.controllers.dtos.CalculateHighestFrequencyBody;
import inteviews.ordinia.WordCount.controllers.dtos.CalculateHighestFrequencyForWordBody;
import inteviews.ordinia.WordCount.controllers.dtos.CalculateMostFrequentNWordsBody;
import inteviews.ordinia.WordCount.exceptions.InvalidInputException;
import inteviews.ordinia.WordCount.services.WordFrequency;
import inteviews.ordinia.WordCount.services.WordFrequencyAnalyzer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static inteviews.ordinia.WordCount.controllers.WordFrequencyController.WORD_FREQUENCY_REQUEST_MAPPING;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(WORD_FREQUENCY_REQUEST_MAPPING)
public class WordFrequencyController {

    public static final String WORD_FREQUENCY_REQUEST_MAPPING = "/word/frequency";
    private final WordFrequencyAnalyzer wordFrequencyAnalyzer;

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> calculateHighestFrequency(
            @RequestBody final CalculateHighestFrequencyBody CalculateHighestFrequencyBody
    ) throws InvalidInputException {

        return ResponseEntity
                .ok()
                .body(wordFrequencyAnalyzer.calculateHighestFrequency(CalculateHighestFrequencyBody.getText()));
    }

    @PostMapping(path = "specific", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> calculateFrequencyForWord(
            @RequestBody final CalculateHighestFrequencyForWordBody calculateHighestFrequencyForWordBody
    ) throws InvalidInputException {

        return ResponseEntity
                .ok()
                .body(wordFrequencyAnalyzer.calculateFrequencyForWord(calculateHighestFrequencyForWordBody.getText(), calculateHighestFrequencyForWordBody.getWord()));
    }

    @PostMapping(path = "nwords", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WordFrequency>> calculateFrequencyForWord(
            @RequestBody final CalculateMostFrequentNWordsBody calculateMostFrequentNWordsBody
    ) throws InvalidInputException {

        return ResponseEntity
                .ok()
                .body(wordFrequencyAnalyzer.calculateMostFrequentNWords(calculateMostFrequentNWordsBody.getText(), calculateMostFrequentNWordsBody.getN()));
    }
}
