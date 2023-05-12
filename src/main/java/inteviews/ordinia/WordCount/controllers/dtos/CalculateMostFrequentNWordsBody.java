package inteviews.ordinia.WordCount.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CalculateMostFrequentNWordsBody extends CalculateHighestFrequencyBody {
    @NonNull
    private int n;
}
