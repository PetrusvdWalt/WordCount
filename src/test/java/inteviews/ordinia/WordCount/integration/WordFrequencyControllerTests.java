package inteviews.ordinia.WordCount.integration;

import inteviews.ordinia.WordCount.services.WordFrequencyAnalyzer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
public class WordFrequencyControllerTests {

    @MockBean
    protected WordFrequencyAnalyzer wordFrequencyAnalyzer;


}
