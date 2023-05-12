package inteviews.ordinia.WordCount.integration;

import inteviews.ordinia.WordCount.services.WordFrequencyAnalyzer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WordFrequencyControllerTests {

    @MockBean
    protected WordFrequencyAnalyzer wordFrequencyAnalyzer;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testWordFrequencyControllerSuccess() throws Exception {
        when(wordFrequencyAnalyzer.calculateHighestFrequency(any())).thenReturn(1);

        this.mockMvc.perform(post("/word/frequency")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"text\": \"Bird is the word, bird\"}")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testWordFrequencyControllerExpectBadRequestNoBody() throws Exception {
        when(wordFrequencyAnalyzer.calculateHighestFrequency(any())).thenReturn(1);

        this.mockMvc.perform(post("/word/frequency")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSpecificFrequencyControllerForWordSuccess() throws Exception {
        when(wordFrequencyAnalyzer.calculateFrequencyForWord(any(), any())).thenReturn(2);

        this.mockMvc.perform(post("/word/frequency/specific")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"text\": \"Bird is the word, bird\", \"word\": \"bird\" }")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testSpecificFrequencyControllerExpectBadRequestNoBody() throws Exception {
        when(wordFrequencyAnalyzer.calculateFrequencyForWord(any(), any())).thenReturn(2);

        this.mockMvc.perform(post("/word/frequency/specific")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


    @Test
    void testNWordCountFrequencyControllerForWordSuccess() throws Exception {
        when(wordFrequencyAnalyzer.calculateMostFrequentNWords(any(), anyInt())).thenReturn(new ArrayList<>());

        this.mockMvc.perform(post("/word/frequency/nwords")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"text\": \"Bird is the word, bird\", \"n\":  1 }")
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void testNWordCountFrequencyControllerExpectBadRequestNoBody() throws Exception {
        when(wordFrequencyAnalyzer.calculateMostFrequentNWords(any(), anyInt())).thenReturn(new ArrayList<>());

        this.mockMvc.perform(post("/word/frequency/nwords")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
