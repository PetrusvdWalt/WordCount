package inteviews.ordinia.WordCount.controllers;

import inteviews.ordinia.WordCount.controllers.dtos.WordFrequencyBody;
import inteviews.ordinia.WordCount.services.InvalidInputException;
import inteviews.ordinia.WordCount.services.WordFrequencyAnalyzer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestBody final WordFrequencyBody WordFrequencyBody
    ) throws InvalidInputException {

        return ResponseEntity
                .ok()
                .body(wordFrequencyAnalyzer.calculateHighestFrequency(WordFrequencyBody.getText()));
    }
}
